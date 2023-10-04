package jackyy.exchangers.registry.crafting;

import com.mojang.serialization.Codec;
import jackyy.exchangers.registry.crafting.condition.module.*;
import jackyy.exchangers.registry.crafting.condition.recipe.*;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCrafting {

    public static final DeferredRegister<Codec<? extends ICondition>> CONDITION_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.CONDITION_SERIALIZERS, Reference.MODID);

    static {
        CONDITION_SERIALIZERS.register("vanilla_module", () -> ConditionVanillaModule.CODEC);
        CONDITION_SERIALIZERS.register("ender_io_module", () -> ConditionEnderIOModule.CODEC);
        CONDITION_SERIALIZERS.register("ender_io_endergy_module", () -> ConditionEnderIOEndergyModule.CODEC);
        CONDITION_SERIALIZERS.register("thermal_module", () -> ConditionThermalModule.CODEC);
        CONDITION_SERIALIZERS.register("mekanism_module", () -> ConditionMekanismModule.CODEC);
        CONDITION_SERIALIZERS.register("immersive_engineering_module", () -> ConditionImmersiveEngineeringModule.CODEC);
        CONDITION_SERIALIZERS.register("special_module", () -> ConditionSpecialModule.CODEC);
        CONDITION_SERIALIZERS.register("vanilla_recipes_type", () -> ConditionVanillaRecipesType.CODEC);
        CONDITION_SERIALIZERS.register("ender_io_recipes_type", () -> ConditionEnderIORecipesType.CODEC);
        CONDITION_SERIALIZERS.register("ender_io_endergy_recipes_type", () -> ConditionEnderIOEndergyRecipesType.CODEC);
        CONDITION_SERIALIZERS.register("thermal_recipes_type", () -> ConditionThermalRecipesType.CODEC);
        CONDITION_SERIALIZERS.register("mekanism_recipes_type", () -> ConditionMekanismRecipesType.CODEC);
        CONDITION_SERIALIZERS.register("immersive_engineering_recipes_type", () -> ConditionImmersiveEngineeringRecipesType.CODEC);
    }

    public static void registerConditions() {
        CONDITION_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
