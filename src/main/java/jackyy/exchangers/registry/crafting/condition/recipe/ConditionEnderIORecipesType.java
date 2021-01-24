package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionEnderIORecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "ender_io_recipes_type");
    private final String value;

    public ConditionEnderIORecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.enderIORecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionEnderIORecipesType> SERIALIZER = new IConditionSerializer<ConditionEnderIORecipesType>() {
        @Override
        public void write(JsonObject json, ConditionEnderIORecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionEnderIORecipesType read(JsonObject json) {
            return new ConditionEnderIORecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
