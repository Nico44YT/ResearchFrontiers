package nazario.researchfrontiers.block;

import nazario.researchfrontiers.registry.BlockRegistry;
import nazario.researchfrontiers.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class WetFireClayBrickBlock extends Block {

    public static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 4, 10, 3, 12);
    public static final IntProperty STAGE = IntProperty.of("stage", 0, 3);

    public WetFireClayBrickBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getStage(state);
            if (i < 3) {
                if (random.nextInt(25) == 0) {
                    world.setBlockState(pos, this.withStage(i + 1), Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return getStage(state) < 3;
    }

    protected int getStage(BlockState state) {
        return state.get(STAGE);
    }

    public BlockState withStage(int stage) {
        return (BlockState)this.getDefaultState().with(STAGE, stage);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(world.isClient) return ActionResult.PASS;

        if(getStage(state) >= 3) {
            player.giveItemStack(new ItemStack(ItemRegistry.FIRE_CLAY_BRICK));
            world.setBlockState(pos, Blocks.AIR.getDefaultState());

            return ActionResult.SUCCESS;
        } else if(player.isSneaking()){
            if(getStage(state) < 3) {
                player.giveItemStack(new ItemStack(BlockRegistry.WET_FIRE_CLAY_BRICK));
                world.setBlockState(pos, Blocks.AIR.getDefaultState());

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(world.isClient) return state;

        if(getStage(state) >= 3) {
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, world);
            itemEntity.setStack(new ItemStack(ItemRegistry.FIRE_CLAY_BRICK));
            itemEntity.setPos(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d);
            world.spawnEntity(itemEntity);

            return Blocks.AIR.getDefaultState();
        } else {
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, world);
            itemEntity.setStack(new ItemStack(BlockRegistry.WET_FIRE_CLAY_BRICK));
            itemEntity.setPos(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d);
            world.spawnEntity(itemEntity);

            return Blocks.AIR.getDefaultState();
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if(!world.getBlockState(pos.down()).isSolidBlock(world, pos.down())) return false;
        return true;
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }

    }
}
