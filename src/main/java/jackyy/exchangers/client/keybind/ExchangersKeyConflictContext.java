package jackyy.exchangers.client.keybind;

import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;

public class ExchangersKeyConflictContext implements IKeyConflictContext {

    public static final IKeyConflictContext INSTANCE = new ExchangersKeyConflictContext();

    @Override
    public boolean isActive() {
        return KeyConflictContext.IN_GAME.isActive();
    }
    @Override
    public boolean conflicts(IKeyConflictContext other) {
        return other == this || KeyConflictContext.IN_GAME.isActive();
    }

}
