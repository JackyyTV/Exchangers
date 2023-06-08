package jackyy.exchangers.integration;

/*
TODO Fix JEI Plugin
import jackyy.exchangers.registry.ModItems;
import jackyy.exchangers.util.Reference;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Reference.MODID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            ItemStack stack = item.get().getDefaultInstance();
            if (stack.getCapability(ForgeCapabilities.ENERGY).isPresent()) {
                registration.registerSubtypeInterpreter(VanillaTypes.ITEM_STACK, item.get(), INTERPRETER);
            }
        }
    }

    private static final IIngredientSubtypeInterpreter<ItemStack> INTERPRETER = (stack, context) -> {
        if (context == UidContext.Ingredient && stack.hasTag()) {
            Optional<IEnergyStorage> capability = stack.getCapability(ForgeCapabilities.ENERGY).resolve();
            if (capability.isPresent()) {
                IEnergyStorage energyStorage = capability.get();
                String subtype;
                if (energyStorage.getEnergyStored() == energyStorage.getMaxEnergyStored()) {
                    subtype = "filled";
                } else {
                    subtype = "empty";
                }
                return subtype;
            }
        }
        return IIngredientSubtypeInterpreter.NONE;
    };

}
*/
