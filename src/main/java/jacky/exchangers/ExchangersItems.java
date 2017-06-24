package jacky.exchangers;

import jacky.exchangers.item.enderio.ItemConductiveIronExchanger;
import jacky.exchangers.item.enderio.ItemDarkSteelExchanger;
import jacky.exchangers.item.enderio.ItemEIOExchangerCoreT1;
import jacky.exchangers.item.enderio.ItemEIOExchangerCoreT2;
import jacky.exchangers.item.enderio.ItemEIOExchangerCoreT3;
import jacky.exchangers.item.enderio.ItemElectricalSteelExchanger;
import jacky.exchangers.item.enderio.ItemEnergeticExchanger;
import jacky.exchangers.item.enderio.ItemPulsatingIronExchanger;
import jacky.exchangers.item.enderio.ItemVibrantExchanger;
import jacky.exchangers.item.mekanism.ItemAdvancedExchanger;
import jacky.exchangers.item.mekanism.ItemBasicExchanger;
import jacky.exchangers.item.mekanism.ItemEliteExchanger;
import jacky.exchangers.item.mekanism.ItemMekanismExchangerCoreT1;
import jacky.exchangers.item.mekanism.ItemMekanismExchangerCoreT2;
import jacky.exchangers.item.mekanism.ItemMekanismExchangerCoreT3;
import jacky.exchangers.item.mekanism.ItemUltimateExchanger;
import jacky.exchangers.item.special.ItemCreativeExchanger;
import jacky.exchangers.item.special.ItemTuberousExchanger;
import jacky.exchangers.item.thermalexpansion.ItemHardenedExchanger;
import jacky.exchangers.item.thermalexpansion.ItemLeadstoneExchanger;
import jacky.exchangers.item.thermalexpansion.ItemReinforcedExchanger;
import jacky.exchangers.item.thermalexpansion.ItemResonantExchanger;
import jacky.exchangers.item.thermalexpansion.ItemSignalumExchanger;
import jacky.exchangers.item.thermalexpansion.ItemTEExchangerCoreT1;
import jacky.exchangers.item.thermalexpansion.ItemTEExchangerCoreT2;
import jacky.exchangers.item.thermalexpansion.ItemTEExchangerCoreT3;
import jacky.exchangers.item.vanilla.ItemDiamondExchanger;
import jacky.exchangers.item.vanilla.ItemEmeraldExchanger;
import jacky.exchangers.item.vanilla.ItemExchangerCoreT1;
import jacky.exchangers.item.vanilla.ItemExchangerCoreT2;
import jacky.exchangers.item.vanilla.ItemExchangerCoreT3;
import jacky.exchangers.item.vanilla.ItemGoldenExchanger;
import jacky.exchangers.item.vanilla.ItemIronExchanger;
import jacky.exchangers.item.vanilla.ItemObsidianExchanger;
import jacky.exchangers.item.vanilla.ItemStoneExchanger;
import jacky.exchangers.item.vanilla.ItemWoodenExchanger;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExchangersItems {

	public static ItemTuberousExchanger tuberousExchanger;
	public static ItemCreativeExchanger creativeExchanger;

	public static ItemWoodenExchanger woodenExchanger;
	public static ItemStoneExchanger stoneExchanger;
	public static ItemGoldenExchanger goldenExchanger;
	public static ItemIronExchanger ironExchanger;
	public static ItemDiamondExchanger diamondExchanger;
	public static ItemEmeraldExchanger emeraldExchanger;
	public static ItemObsidianExchanger obsidianExchanger;
	public static ItemExchangerCoreT1 exchangerCoreT1;
	public static ItemExchangerCoreT2 exchangerCoreT2;
	public static ItemExchangerCoreT3 exchangerCoreT3;

	public static ItemConductiveIronExchanger conductiveIronExchanger;
	public static ItemPulsatingIronExchanger pulsatingIronExchanger;
	public static ItemElectricalSteelExchanger electricalSteelExchanger;
	public static ItemEnergeticExchanger energeticExchanger;
	public static ItemDarkSteelExchanger darkSteelExchanger;
	public static ItemVibrantExchanger vibrantExchanger;
	public static ItemEIOExchangerCoreT1 eioExchangerCoreT1;
	public static ItemEIOExchangerCoreT2 eioExchangerCoreT2;
	public static ItemEIOExchangerCoreT3 eioExchangerCoreT3;

	public static ItemLeadstoneExchanger leadstoneExchanger;
	public static ItemHardenedExchanger hardenedExchanger;
	public static ItemReinforcedExchanger reinforcedExchanger;
	public static ItemSignalumExchanger signalumExchanger;
	public static ItemResonantExchanger resonantExchanger;
	public static ItemTEExchangerCoreT1 teExchangerCoreT1;
	public static ItemTEExchangerCoreT2 teExchangerCoreT2;
	public static ItemTEExchangerCoreT3 teExchangerCoreT3;

	public static ItemBasicExchanger basicExchanger;
	public static ItemAdvancedExchanger advancedExchanger;
	public static ItemEliteExchanger eliteExchanger;
	public static ItemUltimateExchanger ultimateExchanger;
	public static ItemMekanismExchangerCoreT1 mekanismExchangerCoreT1;
	public static ItemMekanismExchangerCoreT2 mekanismExchangerCoreT2;
	public static ItemMekanismExchangerCoreT3 mekanismExchangerCoreT3;

	public static void init() {
		//Special Exchangers
		if (Config.specialModule = true) {
			tuberousExchanger = GameRegistry.register(new ItemTuberousExchanger());
			creativeExchanger = GameRegistry.register(new ItemCreativeExchanger());
		}
		//Vanilla Exchangers
		if (Config.vanillaModule = true) {
			woodenExchanger = GameRegistry.register(new ItemWoodenExchanger());
			stoneExchanger = GameRegistry.register(new ItemStoneExchanger());
			goldenExchanger = GameRegistry.register(new ItemGoldenExchanger());
			ironExchanger = GameRegistry.register(new ItemIronExchanger());
			diamondExchanger = GameRegistry.register(new ItemDiamondExchanger());
			emeraldExchanger = GameRegistry.register(new ItemEmeraldExchanger());
			obsidianExchanger = GameRegistry.register(new ItemObsidianExchanger());
			exchangerCoreT1 = GameRegistry.register(new ItemExchangerCoreT1());
			exchangerCoreT2 = GameRegistry.register(new ItemExchangerCoreT2());
			exchangerCoreT3 = GameRegistry.register(new ItemExchangerCoreT3());
		}
		//Ender IO Exchangers
		if ((Config.enderIOModule = true) && (Loader.isModLoaded("EnderIO"))) {
			conductiveIronExchanger = GameRegistry.register(new ItemConductiveIronExchanger());
			pulsatingIronExchanger = GameRegistry.register(new ItemPulsatingIronExchanger());
			electricalSteelExchanger = GameRegistry.register(new ItemElectricalSteelExchanger());
			energeticExchanger = GameRegistry.register(new ItemEnergeticExchanger());
			darkSteelExchanger = GameRegistry.register(new ItemDarkSteelExchanger());
			vibrantExchanger = GameRegistry.register(new ItemVibrantExchanger());
			eioExchangerCoreT1 = GameRegistry.register(new ItemEIOExchangerCoreT1());
			eioExchangerCoreT2 = GameRegistry.register(new ItemEIOExchangerCoreT2());
			eioExchangerCoreT3 = GameRegistry.register(new ItemEIOExchangerCoreT3());
		}
		//Thermal Expansion Exchangers
		if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded("thermalexpansion"))) {
			leadstoneExchanger = GameRegistry.register(new ItemLeadstoneExchanger());
			hardenedExchanger = GameRegistry.register(new ItemHardenedExchanger());
			reinforcedExchanger = GameRegistry.register(new ItemReinforcedExchanger());
			signalumExchanger = GameRegistry.register(new ItemSignalumExchanger());
			resonantExchanger = GameRegistry.register(new ItemResonantExchanger());
			teExchangerCoreT1 = GameRegistry.register(new ItemTEExchangerCoreT1());
			teExchangerCoreT2 = GameRegistry.register(new ItemTEExchangerCoreT2());
			teExchangerCoreT3 = GameRegistry.register(new ItemTEExchangerCoreT3());
		}
		//Mekanism Exchangers
		if ((Config.mekanismModule = true) && (Loader.isModLoaded("Mekanism"))) {
			basicExchanger = GameRegistry.register(new ItemBasicExchanger());
			advancedExchanger = GameRegistry.register(new ItemAdvancedExchanger());
			eliteExchanger = GameRegistry.register(new ItemEliteExchanger());
			ultimateExchanger = GameRegistry.register(new ItemUltimateExchanger());
			mekanismExchangerCoreT1 = GameRegistry.register(new ItemMekanismExchangerCoreT1());
			mekanismExchangerCoreT2 = GameRegistry.register(new ItemMekanismExchangerCoreT2());
			mekanismExchangerCoreT3 = GameRegistry.register(new ItemMekanismExchangerCoreT3());
		}
	}

	public static void initModels() {
		//Special Exchangers
		if (Config.specialModule = true) {
			tuberousExchanger.initModel();
			creativeExchanger.initModel();
		}
		//Vanilla Exchangers
		if (Config.vanillaModule = true) {
			woodenExchanger.initModel();
			stoneExchanger.initModel();
			goldenExchanger.initModel();
			ironExchanger.initModel();
			diamondExchanger.initModel();
			emeraldExchanger.initModel();
			obsidianExchanger.initModel();
			exchangerCoreT1.initModel();
			exchangerCoreT2.initModel();
			exchangerCoreT3.initModel();
		}
		//Ender IO Exchangers
		if ((Config.enderIOModule = true) && (Loader.isModLoaded("EnderIO"))) {
			conductiveIronExchanger.initModel();
			pulsatingIronExchanger.initModel();
			electricalSteelExchanger.initModel();
			energeticExchanger.initModel();
			darkSteelExchanger.initModel();
			vibrantExchanger.initModel();
			eioExchangerCoreT1.initModel();
			eioExchangerCoreT2.initModel();
			eioExchangerCoreT3.initModel();
		}
		//Thermal Expansion Exchangers
		if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded("thermalexpansion"))) {
			leadstoneExchanger.initModel();
			hardenedExchanger.initModel();
			reinforcedExchanger.initModel();
			signalumExchanger.initModel();
			resonantExchanger.initModel();
			teExchangerCoreT1.initModel();
			teExchangerCoreT2.initModel();
			teExchangerCoreT3.initModel();
		}
		//Mekanism Exchangers
		if ((Config.mekanismModule = true) && (Loader.isModLoaded("Mekanism"))) {
			basicExchanger.initModel();
			advancedExchanger.initModel();
			eliteExchanger.initModel();
			ultimateExchanger.initModel();
			mekanismExchangerCoreT1.initModel();
			mekanismExchangerCoreT2.initModel();
			mekanismExchangerCoreT3.initModel();
		}
	}

}
