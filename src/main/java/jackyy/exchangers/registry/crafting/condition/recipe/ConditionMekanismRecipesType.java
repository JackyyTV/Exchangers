package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionMekanismRecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "mekanism_recipes_type");
    private final String value;

    public ConditionMekanismRecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @Deprecated
    public boolean test() {
        return ModConfigs.CONFIG.mekanismRecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionMekanismRecipesType> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionMekanismRecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionMekanismRecipesType read(JsonObject json) {
            return new ConditionMekanismRecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
