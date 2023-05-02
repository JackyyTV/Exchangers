package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionThermalRecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "thermal_recipes_type");
    private final String value;

    public ConditionThermalRecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.thermalRecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionThermalRecipesType> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionThermalRecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionThermalRecipesType read(JsonObject json) {
            return new ConditionThermalRecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
