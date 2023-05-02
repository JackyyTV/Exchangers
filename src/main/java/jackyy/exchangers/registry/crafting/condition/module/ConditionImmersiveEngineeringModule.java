package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionImmersiveEngineeringModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "immersive_engineering_module");
    private final boolean value;

    public ConditionImmersiveEngineeringModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @Deprecated
    public boolean test() {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() == value;
    }

    public static final IConditionSerializer<ConditionImmersiveEngineeringModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionImmersiveEngineeringModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionImmersiveEngineeringModule read(JsonObject json) {
            return new ConditionImmersiveEngineeringModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
