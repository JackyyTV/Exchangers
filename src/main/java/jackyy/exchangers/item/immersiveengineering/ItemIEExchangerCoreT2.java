package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemIEExchangerCoreT2 extends ItemCoreBase {

    public ItemIEExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() && ModList.get().isLoaded(Reference.IE);
    }

}
