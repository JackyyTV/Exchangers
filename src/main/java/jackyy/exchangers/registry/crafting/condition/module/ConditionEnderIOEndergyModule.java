package jackyy.exchangers.registry.crafting.condition.module;

import com.google.gson.JsonObject;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionEnderIOEndergyModule implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "ender_io_endergy_module");
    private final boolean value;

    public ConditionEnderIOEndergyModule(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test(IContext context) {
        //return ModConfigs.CONFIG.enderIOEndergyModule.get() == value;
        //Disabled recipes for now until Ender IO Endergy gets ported
        return false;
    }

    public static final IConditionSerializer<ConditionEnderIOEndergyModule> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionEnderIOEndergyModule condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionEnderIOEndergyModule read(JsonObject json) {
            return new ConditionEnderIOEndergyModule(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
