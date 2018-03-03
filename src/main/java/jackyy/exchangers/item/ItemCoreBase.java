package jackyy.exchangers.item;

import jackyy.exchangers.Exchangers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemCoreBase extends Item {

    public ItemCoreBase() {
        setMaxStackSize(16);
        setCreativeTab(Exchangers.TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (checkLoaded()) {
            list.add(new ItemStack(this));
        }
    }

    public boolean checkLoaded() {
        return true;
    }

}
