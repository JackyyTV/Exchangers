package jackyy.exchangers.item;

import jackyy.exchangers.util.ILoadable;
import net.minecraft.world.item.Item;

public class ItemCoreBase extends Item implements ILoadable {

    public ItemCoreBase(Properties props) {
        super(props.stacksTo(16));
    }

    @Override
    public boolean checkLoaded() {
        return true;
    }

}
