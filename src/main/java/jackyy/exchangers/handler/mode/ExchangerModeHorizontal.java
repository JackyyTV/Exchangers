package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ExchangerModeHorizontal {

    public static void invoke(Set<BlockPos> coordinates, int range, World world, EnumFacing sideHit, BlockPos pos, Block centerBlock, int centerMeta) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (sideHit == EnumFacing.UP || sideHit == EnumFacing.DOWN) {
            for (int dx = x - range; dx <= x + range; dx++) {
                for (int dz = z - range; dz <= z + range; dz++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerBlock, centerMeta, coordinates);
                }
            }
        } else if (sideHit == EnumFacing.NORTH || sideHit == EnumFacing.SOUTH) {
            for (int dx = x - range; dx <= x + range; dx++) {
                ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, z), centerBlock, centerMeta, coordinates);
            }
        } else if (sideHit == EnumFacing.EAST || sideHit == EnumFacing.WEST) {
            for (int dz = z - range; dz <= z + range; dz++) {
                ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, y, dz), centerBlock, centerMeta, coordinates);
            }
        }
    }

}
