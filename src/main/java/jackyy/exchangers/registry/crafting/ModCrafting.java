package jackyy.exchangers.registry.crafting;

import jackyy.exchangers.registry.crafting.condition.module.*;
import jackyy.exchangers.registry.crafting.condition.recipe.ConditionImmersiveEngineeringRecipesType;
import jackyy.exchangers.registry.crafting.condition.recipe.ConditionMekanismRecipesType;
import jackyy.exchangers.registry.crafting.condition.recipe.ConditionThermalRecipesType;
import jackyy.exchangers.registry.crafting.condition.recipe.ConditionVanillaRecipesType;
import net.minecraftforge.common.crafting.CraftingHelper;

public class ModCrafting {

    public static void registerConditions() {
        CraftingHelper.register(ConditionVanillaModule.SERIALIZER);
        CraftingHelper.register(ConditionThermalModule.SERIALIZER);
        CraftingHelper.register(ConditionMekanismModule.SERIALIZER);
        CraftingHelper.register(ConditionImmersiveEngineeringModule.SERIALIZER);
        CraftingHelper.register(ConditionSpecialModule.SERIALIZER);
        CraftingHelper.register(ConditionVanillaRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionThermalRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionMekanismRecipesType.SERIALIZER);
        CraftingHelper.register(ConditionImmersiveEngineeringRecipesType.SERIALIZER);
    }

}
