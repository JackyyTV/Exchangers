package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionMekanismModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "mekanism_module");
    private final boolean value;

    public ConditionMekanismModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @Deprecated
    public boolean test() {
        return ModConfigs.CONFIG.mekanismModule.get() == value;
    }

    public static final IConditionSerializer<ConditionMekanismModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionMekanismModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionMekanismModule read(JsonObject json) {
            return new ConditionMekanismModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
