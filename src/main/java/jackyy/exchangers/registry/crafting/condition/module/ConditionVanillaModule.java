package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionVanillaModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "vanilla_module");
    private final boolean value;

    public ConditionVanillaModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.vanillaModule.get() == value;
    }

    public static final IConditionSerializer<ConditionVanillaModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionVanillaModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionVanillaModule read(JsonObject json) {
            return new ConditionVanillaModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
