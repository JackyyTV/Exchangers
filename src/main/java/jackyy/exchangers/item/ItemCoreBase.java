package jackyy.exchangers.item;

import jackyy.exchangers.util.ILoadable;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemCoreBase extends Item implements ILoadable {

    public ItemCoreBase(Properties props) {
        super(props.group(Reference.TAB).maxStackSize(16));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (isInGroup(group)) {
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
