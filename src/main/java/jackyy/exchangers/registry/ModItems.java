package jackyy.exchangers.registry;

import jackyy.exchangers.item.enderio.*;
import jackyy.exchangers.item.enderioendergy.*;
import jackyy.exchangers.item.immersiveengineering.*;
import jackyy.exchangers.item.mekanism.*;
import jackyy.exchangers.item.special.ItemBeeExchanger;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.exchangers.item.special.ItemTuberousExchanger;
import jackyy.exchangers.item.thermal.*;
import jackyy.exchangers.item.vanilla.*;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> TUBEROUS_EXCHANGER = ITEMS.register("tuberous_exchanger", ItemTuberousExchanger::new);
    public static final RegistryObject<Item> BEE_EXCHANGER = ITEMS.register("bee_exchanger", ItemBeeExchanger::new);
    public static final RegistryObject<Item> CREATIVE_EXCHANGER = ITEMS.register("creative_exchanger", ItemCreativeExchanger::new);

    public static final RegistryObject<Item> WOODEN_EXCHANGER = ITEMS.register("wooden_exchanger", ItemWoodenExchanger::new);
    public static final RegistryObject<Item> STONE_EXCHANGER = ITEMS.register("stone_exchanger", ItemStoneExchanger::new);
    public static final RegistryObject<Item> GOLDEN_EXCHANGER = ITEMS.register("golden_exchanger", ItemGoldenExchanger::new);
    public static final RegistryObject<Item> IRON_EXCHANGER = ITEMS.register("iron_exchanger", ItemIronExchanger::new);
    public static final RegistryObject<Item> DIAMOND_EXCHANGER = ITEMS.register("diamond_exchanger", ItemDiamondExchanger::new);
    public static final RegistryObject<Item> EMERALD_EXCHANGER = ITEMS.register("emerald_exchanger", ItemEmeraldExchanger::new);
    public static final RegistryObject<Item> OBSIDIAN_EXCHANGER = ITEMS.register("obsidian_exchanger", ItemObsidianExchanger::new);
    public static final RegistryObject<Item> END_EXCHANGER = ITEMS.register("end_exchanger", ItemEndExchanger::new);
    public static final RegistryObject<Item> EXCHANGER_CORE_TIER1 = ITEMS.register("exchanger_core_tier1", ItemExchangerCoreT1::new);
    public static final RegistryObject<Item> EXCHANGER_CORE_TIER2 = ITEMS.register("exchanger_core_tier2", ItemExchangerCoreT2::new);
    public static final RegistryObject<Item> EXCHANGER_CORE_TIER3 = ITEMS.register("exchanger_core_tier3", ItemExchangerCoreT3::new);

    public static final RegistryObject<Item> CONDUCTIVE_IRON_EXCHANGER = ITEMS.register("conductive_iron_exchanger", ItemConductiveIronExchanger::new);
    public static final RegistryObject<Item> PULSATING_IRON_EXCHANGER = ITEMS.register("pulsating_iron_exchanger", ItemPulsatingIronExchanger::new);
    public static final RegistryObject<Item> ELECTRICAL_STEEL_EXCHANGER = ITEMS.register("electrical_steel_exchanger", ItemElectricalSteelExchanger::new);
    public static final RegistryObject<Item> ENERGETIC_EXCHANGER = ITEMS.register("energetic_exchanger", ItemEnergeticExchanger::new);
    public static final RegistryObject<Item> DARK_STEEL_EXCHANGER = ITEMS.register("dark_steel_exchanger", ItemDarkSteelExchanger::new);
    public static final RegistryObject<Item> VIBRANT_EXCHANGER = ITEMS.register("vibrant_exchanger", ItemVibrantExchanger::new);
    public static final RegistryObject<Item> END_STEEL_EXCHANGER = ITEMS.register("end_steel_exchanger", ItemEndSteelExchanger::new);
    public static final RegistryObject<Item> EIO_EXCHANGER_CORE_TIER1 = ITEMS.register("eio_exchanger_core_tier1", ItemEIOExchangerCoreT1::new);
    public static final RegistryObject<Item> EIO_EXCHANGER_CORE_TIER2 = ITEMS.register("eio_exchanger_core_tier2", ItemEIOExchangerCoreT2::new);
    public static final RegistryObject<Item> EIO_EXCHANGER_CORE_TIER3 = ITEMS.register("eio_exchanger_core_tier3", ItemEIOExchangerCoreT3::new);

    public static final RegistryObject<Item> CRUDE_STEEL_EXCHANGER = ITEMS.register("crude_steel_exchanger", ItemCrudeSteelExchanger::new);
    public static final RegistryObject<Item> ENERGETIC_SILVER_EXCHANGER = ITEMS.register("energetic_silver_exchanger", ItemEnergeticSilverExchanger::new);
    public static final RegistryObject<Item> VIVID_EXCHANGER = ITEMS.register("vivid_exchanger", ItemVividExchanger::new);
    public static final RegistryObject<Item> CRYSTALLINE_EXCHANGER = ITEMS.register("crystalline_exchanger", ItemCrystallineExchanger::new);
    public static final RegistryObject<Item> MELODIC_EXCHANGER = ITEMS.register("melodic_exchanger", ItemMelodicExchanger::new);
    public static final RegistryObject<Item> STELLAR_EXCHANGER = ITEMS.register("stellar_exchanger", ItemStellarExchanger::new);
    public static final RegistryObject<Item> EIO_ENDERGY_EXCHANGER_CORE_TIER1 = ITEMS.register("eio_endergy_exchanger_core_tier1", ItemEIOEndergyExchangerCoreT1::new);
    public static final RegistryObject<Item> EIO_ENDERGY_EXCHANGER_CORE_TIER2 = ITEMS.register("eio_endergy_exchanger_core_tier2", ItemEIOEndergyExchangerCoreT2::new);
    public static final RegistryObject<Item> EIO_ENDERGY_EXCHANGER_CORE_TIER3 = ITEMS.register("eio_endergy_exchanger_core_tier3", ItemEIOEndergyExchangerCoreT3::new);

    public static final RegistryObject<Item> LEADSTONE_EXCHANGER = ITEMS.register("leadstone_exchanger", ItemLeadstoneExchanger::new);
    public static final RegistryObject<Item> HARDENED_EXCHANGER = ITEMS.register("hardened_exchanger", ItemHardenedExchanger::new);
    public static final RegistryObject<Item> REINFORCED_EXCHANGER = ITEMS.register("reinforced_exchanger", ItemReinforcedExchanger::new);
    public static final RegistryObject<Item> SIGNALUM_EXCHANGER = ITEMS.register("signalum_exchanger", ItemSignalumExchanger::new);
    public static final RegistryObject<Item> RESONANT_EXCHANGER = ITEMS.register("resonant_exchanger", ItemResonantExchanger::new);
    public static final RegistryObject<Item> THERMAL_EXCHANGER_CORE_TIER1 = ITEMS.register("thermal_exchanger_core_tier1", ItemThermalExchangerCoreT1::new);
    public static final RegistryObject<Item> THERMAL_EXCHANGER_CORE_TIER2 = ITEMS.register("thermal_exchanger_core_tier2", ItemThermalExchangerCoreT2::new);
    public static final RegistryObject<Item> THERMAL_EXCHANGER_CORE_TIER3 = ITEMS.register("thermal_exchanger_core_tier3", ItemThermalExchangerCoreT3::new);

    public static final RegistryObject<Item> BASIC_EXCHANGER = ITEMS.register("basic_exchanger", ItemBasicExchanger::new);
    public static final RegistryObject<Item> ADVANCED_EXCHANGER = ITEMS.register("advanced_exchanger", ItemAdvancedExchanger::new);
    public static final RegistryObject<Item> ELITE_EXCHANGER = ITEMS.register("elite_exchanger", ItemEliteExchanger::new);
    public static final RegistryObject<Item> ULTIMATE_EXCHANGER = ITEMS.register("ultimate_exchanger", ItemUltimateExchanger::new);
    public static final RegistryObject<Item> MEKANISM_EXCHANGER_CORE_TIER1 = ITEMS.register("mekanism_exchanger_core_tier1", ItemMekanismExchangerCoreT1::new);
    public static final RegistryObject<Item> MEKANISM_EXCHANGER_CORE_TIER2 = ITEMS.register("mekanism_exchanger_core_tier2", ItemMekanismExchangerCoreT2::new);
    public static final RegistryObject<Item> MEKANISM_EXCHANGER_CORE_TIER3 = ITEMS.register("mekanism_exchanger_core_tier3", ItemMekanismExchangerCoreT3::new);

    public static final RegistryObject<Item> LV_EXCHANGER = ITEMS.register("lv_exchanger", ItemLVExchanger::new);
    public static final RegistryObject<Item> MV_EXCHANGER = ITEMS.register("mv_exchanger", ItemMVExchanger::new);
    public static final RegistryObject<Item> HV_EXCHANGER = ITEMS.register("hv_exchanger", ItemHVExchanger::new);
    public static final RegistryObject<Item> IE_EXCHANGER_CORE_TIER1 = ITEMS.register("ie_exchanger_core_tier1", ItemIEExchangerCoreT1::new);
    public static final RegistryObject<Item> IE_EXCHANGER_CORE_TIER2 = ITEMS.register("ie_exchanger_core_tier2", ItemIEExchangerCoreT2::new);
    public static final RegistryObject<Item> IE_EXCHANGER_CORE_TIER3 = ITEMS.register("ie_exchanger_core_tier3", ItemIEExchangerCoreT3::new);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
