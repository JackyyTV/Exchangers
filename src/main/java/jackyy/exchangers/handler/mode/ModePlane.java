package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModePlane {

    public static void invoke(Set<BlockPos> coordinates, int range, Level world, Direction sideHit, BlockPos pos, BlockState centerState) {
        List<BlockPos> possibleLocs = new ArrayList<>();
        possibleLocs.add(pos);
        int index = 0;
        do {
            BlockPos currentPos = possibleLocs.get(index);
            ExchangerHandler.checkAndAddBlock(world, currentPos, centerState, coordinates);
            switch (sideHit) {
                case UP -> getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerState, range, true);
                case DOWN -> getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerState, range, false);
                case SOUTH -> getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerState, range, true);
                case NORTH -> getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerState, range, false);
                case EAST -> getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerState, range, true);
                case WEST -> getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerState, range, false);
            }
            index++;
        } while (index < possibleLocs.size());
    }

    public static MutableComponent getDisplayName() {
        return StringHelper.localize(Reference.MODID, "mode.plane");
    }

    private static void getConnectedBlocksUD(List<BlockPos> possibleLocs, Level world, BlockPos currentPos, BlockPos centerPos, BlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.offset(x, 0, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + range && newPos.getX() >= centerPos.getX() - range)
                        if (newPos.getZ() <= centerPos.getZ() + range && newPos.getZ() >= centerPos.getZ() - range)
                            if (!world.getBlockState(newPos.offset(0, side ? 1 : -1, 0)).canOcclude() && checkBlock(world, newPos, centerState))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksNS(List<BlockPos> possibleLocs, Level world, BlockPos currentPos, BlockPos centerPos, BlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.offset(x, y, 0);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + range && newPos.getX() >= centerPos.getX() - range)
                        if (newPos.getY() <= centerPos.getY() + range && newPos.getY() >= centerPos.getY() - range)
                            if (!world.getBlockState(newPos.offset(0, 0, side ? 1 : -1)).canOcclude() && checkBlock(world, newPos, centerState))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksEW(List<BlockPos> possibleLocs, Level world, BlockPos currentPos, BlockPos centerPos, BlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.offset(0, x, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getY() <= centerPos.getY() + range && newPos.getY() >= centerPos.getY() - range)
                        if (newPos.getZ() <= centerPos.getZ() + range && newPos.getZ() >= centerPos.getZ() - range)
                            if (!world.getBlockState(newPos.offset(side ? 1 : -1, 0, 0)).canOcclude() && checkBlock(world, newPos, centerState))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static boolean isLocationContained(List<BlockPos> possibleLocs, BlockPos toFind) {
        for (BlockPos pos : possibleLocs)
            if (pos.getX() == toFind.getX() && pos.getY() == toFind.getY() && pos.getZ() == toFind.getZ())
                return true;
        return false;
    }

    private static boolean checkBlock(Level world, BlockPos pos, BlockState centerState) {
        BlockState state = world.getBlockState(pos);
        return state == centerState;
    }

}
