package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ExchangerModeHorizontalCol {

    public static void invoke(Set<BlockPos> coordinates, int range, World world, EntityPlayer player, EnumFacing sideHit, BlockPos pos, IBlockState centerState) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int rangeX, rangeZ;
        EnumFacing facing = player.getHorizontalFacing();
        switch (facing) {
            case SOUTH:
            case NORTH:
                rangeX = range;
                rangeZ = 0;
                break;
            default:
                rangeX = 0;
                rangeZ = range;
        }
        switch (sideHit) {
            case UP:
            case DOWN:
                for (int dx = x - rangeX; dx <= x + rangeX; dx++) {
                    for (int dz = z - rangeZ; dz <= z + rangeZ; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerState, coordinates);
                    }
                }
                break;
            case SOUTH:
            case NORTH:
                for (int dx = x - range; dx <= x + range; dx++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, z), centerState, coordinates);
                }
                break;
            case EAST:
            case WEST:
                for (int dz = z - range; dz <= z + range; dz++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, y, dz), centerState, coordinates);
                }
        }
    }

}
