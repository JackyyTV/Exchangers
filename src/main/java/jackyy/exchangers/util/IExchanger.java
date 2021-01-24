package jackyy.exchangers.util;

public interface IExchanger {

    default int getTier() {
        return 0;
    }

    default int getHarvestLevel() {
        return 0;
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
