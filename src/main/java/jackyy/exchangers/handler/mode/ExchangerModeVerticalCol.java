package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ExchangerModeVerticalCol {

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
                for (int dx = x - rangeZ; dx <= x + rangeZ; dx++) {
                    for (int dz = z - rangeX; dz <= z + rangeX; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerState, coordinates);
                    }
                }
                break;
            default:
                for (int dy = y - range; dy <= y + range; dy++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, dy, z), centerState, coordinates);
                }
        }
    }

}
