package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionThermalModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "thermal_module");
    private final boolean value;

    public ConditionThermalModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @SuppressWarnings("removal")
    public boolean test() {
        return ModConfigs.CONFIG.thermalModule.get() == value;
    }

    public static final IConditionSerializer<ConditionThermalModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionThermalModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionThermalModule read(JsonObject json) {
            return new ConditionThermalModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
