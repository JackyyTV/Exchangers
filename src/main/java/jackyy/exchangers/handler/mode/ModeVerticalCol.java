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

public class ModeVerticalCol {

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
                for (int dx = x - rangeZ; dx <= x + rangeZ; dx++) {
                    for (int dz = z - rangeX; dz <= z + rangeX; dz++) {
                        ExchangerHandler.checkAndAddBlock(world, new BlockPos(dx, y, dz), centerState, coordinates);
                    }
                }
            }
            default -> {
                for (int dy = y - range; dy <= y + range; dy++) {
                    ExchangerHandler.checkAndAddBlock(world, new BlockPos(x, dy, z), centerState, coordinates);
                }
            }
        }
    }

    public static MutableComponent getDisplayName() {
        return StringHelper.localize(Reference.MODID, "mode.vertical");
    }

}
