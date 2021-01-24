package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.world.World;

import java.util.Set;

public class ModeHorizontalCol {

    public static void invoke(Set<BlockPos> coordinates, int range, World world, PlayerEntity player, Direction sideHit, BlockPos pos, BlockState centerState) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int rangeX, rangeZ;
        Direction facing = player.getHorizontalFacing();
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

    public static IFormattableTextComponent getDisplayName() {
        return StringHelper.localize(Reference.MODID, "mode.horizontal");
    }

}
