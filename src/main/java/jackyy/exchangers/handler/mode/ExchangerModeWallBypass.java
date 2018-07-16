package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ExchangerModeWallBypass {

    public static void invoke(Set<BlockPos> coordinates, int range, World world, EnumFacing sideHit, BlockPos pos, Block centerBlock, int centerMeta) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        switch (sideHit) {
            case UP:
            case DOWN:
                for (int dx = x - range; dx <= x + range; dx++) {
                    for (int dz = z - range; dz <= z + range; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerBlock, centerMeta, coordinates);
                    }
                }
                break;
            case SOUTH:
            case NORTH:
                for (int dx = x - range; dx <= x + range; dx++) {
                    for (int dy = y - range; dy <= y + range; dy++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, dy, z), centerBlock, centerMeta, coordinates);
                    }
                }
                break;
            case EAST:
            case WEST:
                for (int dy = y - range; dy <= y + range; dy++) {
                    for (int dz = z - range; dz <= z + range; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, dy, dz), centerBlock, centerMeta, coordinates);
                    }
                }
        }
    }

}
