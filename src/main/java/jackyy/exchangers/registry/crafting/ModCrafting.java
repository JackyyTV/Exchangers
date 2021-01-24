package jackyy.exchangers.registry.crafting;

import jackyy.exchangers.registry.crafting.condition.module.*;
import jackyy.exchangers.registry.crafting.condition.recipe.*;
import net.minecraftforge.common.crafting.CraftingHelper;

public class ModCrafting {

    public static void registerConditions() {
        CraftingHelper.register(ConditionVanillaModule.SERIALIZER);
        CraftingHelper.register(ConditionEnderIOModule.SERIALIZER);
        CraftingHelper.register(ConditionEnderIOEndergyModule.SERIALIZER);
        CraftingHelper.register(ConditionThermalModule.SERIALIZER);
        CraftingHelper.register(ConditionMekanismModule.SERIALIZER);
        CraftingHelper.register(ConditionImmersiveEngineeringModule.SERIALIZER);
        CraftingHelper.register(ConditionSpecialModule.SERIALIZER);
        CraftingHelper.register(ConditionVanillaRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionEnderIORecipesType.SERIALIZER);
        CraftingHelper.register(ConditionEnderIOEndergyRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionThermalRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionMekanismRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionImmersiveEngineeringRecipesType.SERIALIZER);
    }

}
