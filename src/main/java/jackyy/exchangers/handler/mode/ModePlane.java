package jackyy.exchangers.handler.mode;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModePlane {

    public static void invoke(Set<BlockPos> coordinates, int range, World world, EnumFacing sideHit, BlockPos pos, IBlockState centerState) {
        List<BlockPos> possibleLocs = new ArrayList<>();
        possibleLocs.add(pos);
        int index = 0;
        do {
            BlockPos currentPos = possibleLocs.get(index);
            ExchangerHandler.checkAndAddBlock(world, currentPos, centerState, coordinates);
            switch (sideHit) {
                case UP:
                    getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerState, range, true);
                    break;
                case DOWN:
                    getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerState, range, false);
                    break;
                case SOUTH:
                    getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerState, range, true);
                    break;
                case NORTH:
                    getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerState, range, false);
                    break;
                case EAST:
                    getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerState, range, true);
                    break;
                case WEST:
                    getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerState, range, false);
                    break;
            }
            index++;
        } while (index < possibleLocs.size());
    }

    public static String getDisplayName() {
        return StringHelper.localize(Reference.MODID, "mode.plane");
    }

    private static void getConnectedBlocksUD(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, IBlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(x, 0, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + range && newPos.getX() >= centerPos.getX() - range)
                        if (newPos.getZ() <= centerPos.getZ() + range && newPos.getZ() >= centerPos.getZ() - range)
                            if (!world.getBlockState(newPos.add(0, side ? 1 : -1, 0)).isFullBlock() && checkBlock(world, newPos, centerState))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksNS(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, IBlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(x, y, 0);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + range && newPos.getX() >= centerPos.getX() - range)
                        if (newPos.getY() <= centerPos.getY() + range && newPos.getY() >= centerPos.getY() - range)
                            if (!world.getBlockState(newPos.add(0, 0, side ? 1 : -1)).isFullBlock() && checkBlock(world, newPos, centerState))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksEW(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, IBlockState centerState, int range, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(0, x, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getY() <= centerPos.getY() + range && newPos.getY() >= centerPos.getY() - range)
                        if (newPos.getZ() <= centerPos.getZ() + range && newPos.getZ() >= centerPos.getZ() - range)
                            if (!world.getBlockState(newPos.add(side ? 1 : -1, 0, 0)).isFullBlock() && checkBlock(world, newPos, centerState))
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

    private static boolean checkBlock(World world, BlockPos pos, IBlockState centerState) {
        IBlockState state = world.getBlockState(pos);
        return state == centerState;
    }

}
