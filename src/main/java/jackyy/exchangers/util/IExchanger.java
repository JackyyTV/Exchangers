package jackyy.exchangers.util;

public interface IExchanger {

    default int getTier() {
        return this.getTier();
    }

    default int getMaxRange() {
        return this.getMaxRange();
    }

    default int getMaxEnergy() {
        return this.getMaxEnergy();
    }

    default int getPerBlockUse() {
        return this.getPerBlockUse();
    }

    default boolean isCreative() {
        return false;
    }

    default boolean isPowered() {
        return false;
    }

    default boolean checkLoaded() {
        return this.checkLoaded();
    }

}
