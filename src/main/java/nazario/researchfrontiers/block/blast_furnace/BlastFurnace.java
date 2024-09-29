package nazario.researchfrontiers.block.blast_furnace;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlastFurnace extends BlockWithEntity {
    public static final MapCodec<BlastFurnace> CODEC = createCodec(BlastFurnace::new);


    public static final EnumProperty<BlastFurnaceState> OPEN = EnumProperty.of("door", BlastFurnaceState.class);

    public BlastFurnace(Settings settings) {
        super(settings);
        // Set the default state with OPEN set to false
        this.setDefaultState(this.stateManager.getDefaultState().with(OPEN, BlastFurnaceState.CLOSED));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Ensure the block is placed with OPEN set to false
        return this.getDefaultState().with(OPEN, BlastFurnaceState.CLOSED);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) return ActionResult.CONSUME;
        if (player.isSneaking()) {
            // Toggle the OPEN state when the player is sneaking
            world.setBlockState(pos, state.with(OPEN, BlastFurnaceState.OPEN));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        // Pass the current state with the correct OPEN value to the block entity
        return new BlastFurnaceEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OPEN);
    }
}
