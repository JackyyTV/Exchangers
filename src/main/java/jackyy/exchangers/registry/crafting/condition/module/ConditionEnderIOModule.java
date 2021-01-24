package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionEnderIOModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "ender_io_module");
    private final boolean value;

    public ConditionEnderIOModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        //return ModConfigs.CONFIG.enderIOModule.get() == value;
        //Disabled recipes for now until Ender IO gets ported
        return false;
    }

    public static final IConditionSerializer<ConditionEnderIOModule> SERIALIZER = new IConditionSerializer<ConditionEnderIOModule>() {
        @Override
        public void write(JsonObject json, ConditionEnderIOModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionEnderIOModule read(JsonObject json) {
            return new ConditionEnderIOModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
