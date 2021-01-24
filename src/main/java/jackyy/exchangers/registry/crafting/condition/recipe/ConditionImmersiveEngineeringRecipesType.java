package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionImmersiveEngineeringRecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "immersive_engineering_recipes_type");
    private final String value;

    public ConditionImmersiveEngineeringRecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.immersiveEngineeringRecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionImmersiveEngineeringRecipesType> SERIALIZER = new IConditionSerializer<ConditionImmersiveEngineeringRecipesType>() {
        @Override
        public void write(JsonObject json, ConditionImmersiveEngineeringRecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionImmersiveEngineeringRecipesType read(JsonObject json) {
            return new ConditionImmersiveEngineeringRecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
