package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Cable {
    public static class BlockEntity extends net.minecraft.block.entity.BlockEntity {
        int color = 0;

        public BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityRegistry.CABLE_BLOCK_ENTITY, pos, state);
        }

        @Override
        protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
            super.readNbt(nbt, registryLookup);
            color = nbt.getInt("color");

            // When the data is modified through "/data" command,
            // or placed by an item with "block_entity_data" component,
            // the render color will be updated.
            if (world != null) {
                world.updateListeners(pos, getCachedState(), getCachedState(), 0);
            }
        }

        @Override
        protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
            super.writeNbt(nbt, registryLookup);
            nbt.putInt("color", color);
        }

        @Override
        public @Nullable Object getRenderData() {
            return color;
        }


        @Nullable
        @Override
        public Packet<ClientPlayPacketListener> toUpdatePacket() {
            return BlockEntityUpdateS2CPacket.create(this);
        }

        @Override
        public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
            return createNbt(registryLookup);
        }
    }

    public static class Block extends BlockWithEntity {
        public Block(Settings settings) {
            super(settings);
        }

        @Override
        protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (stack.getItem() instanceof DyeItem dyeItem) {
                if (world.getBlockEntity(pos) instanceof Cable.BlockEntity colorBlockEntity) {
                    final int newColor = dyeItem.getColor().getEntityColor();
                    final int originalColor = colorBlockEntity.color;
                    colorBlockEntity.color = ColorHelper.Argb.averageArgb(newColor, originalColor);
                    stack.decrementUnlessCreative(1, player);
                    colorBlockEntity.markDirty();
                    world.updateListeners(pos, state, state, 0);

                    return ItemActionResult.SUCCESS;
                }
            }
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }

        @Override
        protected MapCodec<? extends BlockWithEntity> getCodec() {
            return createCodec(Cable.Block::new);
        }

        @Nullable
        @Override
        public net.minecraft.block.entity.BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
            return new Cable.BlockEntity(pos, state);
        }

        @Override
        protected BlockRenderType getRenderType(BlockState state) {
            return BlockRenderType.MODEL;
        }
    }
}