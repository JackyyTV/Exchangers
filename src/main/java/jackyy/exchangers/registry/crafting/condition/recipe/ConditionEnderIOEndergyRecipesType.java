package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionEnderIOEndergyRecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "ender_io_endergy_recipes_type");
    private final String value;

    public ConditionEnderIOEndergyRecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.enderIOEndergyRecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionEnderIOEndergyRecipesType> SERIALIZER = new IConditionSerializer<ConditionEnderIOEndergyRecipesType>() {
        @Override
        public void write(JsonObject json, ConditionEnderIOEndergyRecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionEnderIOEndergyRecipesType read(JsonObject json) {
            return new ConditionEnderIOEndergyRecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
