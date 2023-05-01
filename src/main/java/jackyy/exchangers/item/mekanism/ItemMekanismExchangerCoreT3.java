package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMekanismExchangerCoreT3 extends ItemCoreBase {

    public ItemMekanismExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.mekanismModule.get()  && ModList.get().isLoaded(Reference.MEK);
    }

}
