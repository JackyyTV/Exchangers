package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public class ModeHorizontalCol {

    public static void invoke(Set<BlockPos> coordinates, int range, Level world, Player player, Direction sideHit, BlockPos pos, BlockState centerState) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int rangeX, rangeZ;
        Direction facing = player.getMotionDirection();
        switch (facing) {
            case SOUTH, NORTH -> {
                rangeX = range;
                rangeZ = 0;
            }
            default -> {
                rangeX = 0;
                rangeZ = range;
            }
        }
        switch (sideHit) {
            case UP, DOWN -> {
                for (int dx = x - rangeX; dx <= x + rangeX; dx++) {
                    for (int dz = z - rangeZ; dz <= z + rangeZ; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerState, coordinates);
                    }
                }
            }
            case SOUTH, NORTH -> {
                for (int dx = x - range; dx <= x + range; dx++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, z), centerState, coordinates);
                }
            }
            case EAST, WEST -> {
                for (int dz = z - range; dz <= z + range; dz++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, y, dz), centerState, coordinates);
                }
            }
        }
    }

    public static MutableComponent getDisplayName() {
        return StringHelper.localize(Reference.MODID, "mode.horizontal");
    }

}
