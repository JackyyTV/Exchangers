package jackyy.exchangers.util;

public interface IExchanger {

    default int getTier() {
        return 0;
    }

    default String getHarvestLevel() {
        return "minecraft:wood";
    }

    default String getDefaultHarvestLevel() {
        return "minecraft:wood";
    }

    default int getMaxRange() {
        return 0;
    }

    default int getMaxEnergy() {
        return 0;
    }

    default int getPerBlockUse() {
        return 0;
    }

    default boolean isCreative() {
        return false;
    }

    default boolean isPowered() {
        return false;
    }

}
