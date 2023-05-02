package jackyy.exchangers.item;

import jackyy.exchangers.util.ILoadable;
import jackyy.exchangers.util.Reference;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemCoreBase extends Item implements ILoadable {

    public ItemCoreBase(Properties props) {
        super(props.tab(Reference.TAB).stacksTo(16));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (allowdedIn(tab)) {
            if (checkLoaded()) {
                items.add(new ItemStack(this));
            }
        }
    }

    @Override
    public boolean checkLoaded() {
        return true;
    }

}
