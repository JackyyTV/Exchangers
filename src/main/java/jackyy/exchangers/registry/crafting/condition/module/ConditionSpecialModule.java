package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionSpecialModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "special_module");
    private final boolean value;

    public ConditionSpecialModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @Deprecated
    public boolean test() {
        return ModConfigs.CONFIG.specialModule.get() == value;
    }

    public static final IConditionSerializer<ConditionSpecialModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionSpecialModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionSpecialModule read(JsonObject json) {
            return new ConditionSpecialModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
