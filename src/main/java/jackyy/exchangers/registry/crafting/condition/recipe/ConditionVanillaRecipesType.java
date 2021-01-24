package jackyy.exchangers.registry.crafting.condition.recipe;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionVanillaRecipesType implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "vanilla_recipes_type");
    private final String value;

    public ConditionVanillaRecipesType(String value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.vanillaRecipesType.get().equals(value);
    }

    public static final IConditionSerializer<ConditionVanillaRecipesType> SERIALIZER = new IConditionSerializer<ConditionVanillaRecipesType>() {
        @Override
        public void write(JsonObject json, ConditionVanillaRecipesType condition) {
            json.addProperty("value", condition.value);
        }

        @Override
        public ConditionVanillaRecipesType read(JsonObject json) {
            return new ConditionVanillaRecipesType(json.get("value").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
