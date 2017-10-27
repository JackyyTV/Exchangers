package me.jacky1356400.exchangers.init;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.ImmersiveEngineeringIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import me.jacky1356400.exchangers.item.ItemBasic;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.item.ItemPoweredExchanger;
import me.jacky1356400.exchangers.item.special.ItemTuberousExchanger;
import me.jacky1356400.exchangers.util.Data;
import me.jacky1356400.exchangers.util.EnumTier;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRegistry {

    public static final Item WOODEN = new ItemExchanger("exwooden", EnumTier.ONE, Config.woodMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item STONE = new ItemExchanger("exstone", EnumTier.TWO, Config.stoneMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item GOLD = new ItemExchanger("exgolden", EnumTier.THREE, Config.goldMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item IRON = new ItemExchanger("exiron", EnumTier.FOUR, Config.ironMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item DIAMOND = new ItemExchanger("exdiamond", EnumTier.FIVE, Config.diaMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item EMERALD = new ItemExchanger("exemerald", EnumTier.SIX, Config.emeMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item OBSIDIAN = new ItemExchanger("exobsidian", EnumTier.SEVEN, Config.obsMaxDmg) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item CONDUCTIVE = new ItemPoweredExchanger("exconductive", EnumTier.EIO_ONE, Config.conductiveMaxEnergy, Config.conductivePerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item PULSATING = new ItemPoweredExchanger("expulsating", EnumTier.EIO_TWO, Config.pulsatingMaxEnergy, Config.pulsatingPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item ELECTRICALSTEEL = new ItemPoweredExchanger("exelectricalsteel", EnumTier.EIO_THREE, Config.electricalSteelMaxEnergy, Config.electricalSteelPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item ENERGETIC = new ItemPoweredExchanger("exenergetic", EnumTier.EIO_FOUR, Config.energeticMaxEnergy, Config.energeticPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item DARKSTEEL = new ItemPoweredExchanger("exdarksteel", EnumTier.EIO_FIVE, Config.darkSteelMaxEnergy, Config.darkSteelPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item VIBRANT = new ItemPoweredExchanger("exvibrant", EnumTier.EIO_SIX, Config.vibrantMaxEnergy, Config.vibrantPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item LEADSTONE = new ItemPoweredExchanger("exleadstone", EnumTier.TE_ONE, Config.leadstoneMaxEnergy, Config.leadstonePerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item HARDENED = new ItemPoweredExchanger("exhardened", EnumTier.TE_TWO, Config.hardenedMaxEnergy, Config.hardenedPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item REINFORCED = new ItemPoweredExchanger("exreinforced", EnumTier.TE_THREE, Config.reinforcedMaxEnergy, Config.reinforcedPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item SIGNALUM = new ItemPoweredExchanger("exsignalum", EnumTier.TE_FOUR, Config.signalumMaxEnergy, Config.signalumPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item RESONANT = new ItemPoweredExchanger("exresonant", EnumTier.TE_FIVE, Config.resonantMaxEnergy, Config.resonantPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item BASIC = new ItemPoweredExchanger("exbasic", EnumTier.MEK_ONE, Config.basicMaxEnergy, Config.basicPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item ADVANCED = new ItemPoweredExchanger("exadvanced", EnumTier.MEK_TWO, Config.advancedMaxEnergy, Config.advancedPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item ELITE = new ItemPoweredExchanger("exelite", EnumTier.MEK_THREE, Config.eliteMaxEnergy, Config.elitePerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item ULTIMATE = new ItemPoweredExchanger("exultimate", EnumTier.MEK_FOUR, Config.ultimateMaxEnergy, Config.ultimatePerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item LV = new ItemPoweredExchanger("exlv", EnumTier.IE_ONE, Config.lvMaxEnergy, Config.lvPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item MV = new ItemPoweredExchanger("exmv", EnumTier.IE_TWO, Config.mvMaxEnergy, Config.mvPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item HV = new ItemPoweredExchanger("exhv", EnumTier.IE_THREE, Config.hvMaxEnergy, Config.hvPerBlockUse) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        ItemStack empty = new ItemStack(this);
                        list.add(empty);
                        ItemStack full = new ItemStack(this);
                        EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                        list.add(full);
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item CREATIVE = new ItemExchanger("excreative", EnumTier.CREATIVE, 9001) {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.specialModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item POTATO = new ItemTuberousExchanger() {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.specialModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.UNCOMMON;
        }
    };
    public static final Item CORE_1 = new ItemBasic("excore_t1") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item CORE_2 = new ItemBasic("excore_t2") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item CORE_3 = new ItemBasic("excore_t3") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.vanillaModule) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item EIOCORE_1 = new ItemBasic("eioexcore_t1") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item EIOCORE_2 = new ItemBasic("eioexcore_t2") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item EIOCORE_3 = new ItemBasic("eioexcore_t3") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.enderIOModule) {
                if (Loader.isModLoaded(Data.EIO)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item TECORE_1 = new ItemBasic("teexcore_t1") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item TECORE_2 = new ItemBasic("teexcore_t2") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item TECORE_3 = new ItemBasic("teexcore_t3") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.thermalExpansionModule) {
                if (Loader.isModLoaded(Data.THERMAL)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item MEKCORE_1 = new ItemBasic("mekexcore_t1") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item MEKCORE_2 = new ItemBasic("mekexcore_t2") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item MEKCORE_3 = new ItemBasic("mekexcore_t3") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.mekanismModule) {
                if (Loader.isModLoaded(Data.MEK)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };
    public static final Item IECORE_1 = new ItemBasic("ieexcore_t1") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return Data.TIER_1;
        }
    };
    public static final Item IECORE_2 = new ItemBasic("ieexcore_t2") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }
    };
    public static final Item IECORE_3 = new ItemBasic("ieexcore_t3") {
        @Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
            if (Config.immersiveEngineeringModule) {
                if (Loader.isModLoaded(Data.IE)) {
                    if (isInCreativeTab(tab)) {
                        list.add(new ItemStack(this));
                    }
                }
            }
        }
        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.EPIC;
        }
    };

    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(Data.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public void onRecipeRegistry(RegistryEvent.Register<IRecipe> e) {
        if (Config.enderIOModule) {
            if (Loader.isModLoaded(Data.EIO)) {
                EnderIOIntegration.init();
            }
        }
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Data.THERMAL)) {
                ThermalExpansionIntegration.init();
            }
        }
        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Data.MEK)) {
                MekanismIntegration.init();
            }
        }
        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Data.IE)) {
                ImmersiveEngineeringIntegration.init();
            }
        }
        if (Config.vanillaModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Data.MODID + ":wooden_exchanger"), null, new ItemStack(WOODEN),
                            "WEW", "WCW", "WEW", 'W', "logWood",
                            'E', Items.ENDER_EYE, 'C', CORE_1
            );
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Data.MODID + ":vanilla_core_tier1"), null, new ItemStack(CORE_1),
                            "WRW", "RPR", "WRW",
                            'R', "dyeRed", 'W', "logWood", 'P', "enderpearl"
            );
            switch (Config.vanillaRecipesType) {
                case "easy": {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":stone_exchanger_easy"), null, new ItemStack(STONE),
                                    "SES", "SCS", "SES",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', CORE_1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":golden_exchanger_easy"), null, new ItemStack(GOLD),
                                    "GEG", "GCG", "GEG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', CORE_2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":iron_exchanger_easy"), null, new ItemStack(IRON),
                                    "IEI", "ICI", "IEI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', CORE_2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":diamond_exchanger_easy"), null, new ItemStack(DIAMOND),
                                    "DED", "DCD", "DED",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', CORE_3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":emerald_exchanger_easy"), null, new ItemStack(EMERALD),
                                    "MEM", "MCM", "MEM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', CORE_3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":obsidian_exchanger_easy"), null, new ItemStack(OBSIDIAN),
                                    "OEO", "OCO", "OEO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', CORE_3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier2_easy"), null, new ItemStack(CORE_2),
                                    "ILI", "LEL", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', CORE_1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier3_easy"), null, new ItemStack(CORE_3),
                                    "DED", "EBE", "DED",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', CORE_2, 'B', "blockDiamond"
                    );
                    break;
                }
                case "normal": {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":stone_exchanger_normal"), null, new ItemStack(STONE),
                                    "SCS", "EXE", "SSS",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', CORE_1, 'X', WOODEN
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":golden_exchanger_normal"), null, new ItemStack(GOLD),
                                    "GCG", "EXE", "GGG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', CORE_2, 'X', STONE
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":iron_exchanger_normal"), null, new ItemStack(IRON),
                                    "ICI", "EXE", "III",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', CORE_2, 'X', GOLD
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":diamond_exchanger_normal"), null, new ItemStack(DIAMOND),
                                    "DCD", "EXE", "DDD",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', IRON
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":emerald_exchanger_normal"), null, new ItemStack(EMERALD),
                                    "MCM", "EXE", "MMM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', DIAMOND
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":obsidian_exchanger_normal"), null, new ItemStack(OBSIDIAN),
                                    "OCO", "EXE", "OOO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', EMERALD
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier2_normal"), null, new ItemStack(CORE_2),
                                    "ILI", "ECE", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', CORE_1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier3_normal"), null, new ItemStack(CORE_3),
                                    "DED", "BCB", "DED",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', CORE_2, 'B', "blockDiamond"
                    );
                    break;
                }
                case "hard": {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":stone_exchanger_hard"), null, new ItemStack(STONE),
                                    "SES", "CXC", "SES",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', CORE_1, 'X', WOODEN
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":golden_exchanger_hard"), null, new ItemStack(GOLD),
                                    "GEG", "CXC", "GEG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', CORE_2, 'X', STONE
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":iron_exchanger_hard"), null, new ItemStack(IRON),
                                    "IEI", "CXC", "IEI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', CORE_2, 'X', GOLD
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":diamond_exchanger_hard"), null, new ItemStack(DIAMOND),
                                    "DED", "CXC", "DED",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', IRON
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":emerald_exchanger_hard"), null, new ItemStack(EMERALD),
                                    "MEM", "CXC", "MEM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', DIAMOND
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":obsidian_exchanger_hard"), null, new ItemStack(OBSIDIAN),
                                    "OEO", "CXC", "OEO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', CORE_3, 'X', EMERALD
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier2_hard"), null, new ItemStack(CORE_2),
                                    "ILI", "CEC", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', CORE_1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Data.MODID + ":vanilla_core_tier3_hard"), null, new ItemStack(CORE_3),
                                    "DCE", "CBC", "ECD",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', CORE_2, 'B', "blockDiamond"
                    );
                    break;
                }
            }
        }

        if (Config.enderIOModule) {
            if (Loader.isModLoaded(Data.EIO)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":conductive_exchanger"), null, new ItemStack(CONDUCTIVE),
                                "IBI", "ICI", "IBI",
                                'I', "ingotConductiveIron", 'B', EnderIOIntegration.basicCapacitor, 'C', EIOCORE_1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":eio_core_tier1"), null, new ItemStack(EIOCORE_1),
                                "PCP", "CNC", "PCP",
                                'P', "nuggetPulsatingIron", 'C', "ingotConductiveIron", 'N', EnderIOIntegration.bucketNutrientDistillation
                );
                switch (Config.enderIORecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":pulsating_exchanger_easy"), null, new ItemStack(PULSATING),
                                        "IPI", "ICI", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', EIOCORE_1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":electricalsteel_exchanger_easy"), null, new ItemStack(ELECTRICALSTEEL),
                                        "SDS", "SCS", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":energetic_exchanger_easy"), null, new ItemStack(ENERGETIC),
                                        "ADA", "ACA", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":darksteel_exchanger_easy"), null, new ItemStack(DARKSTEEL),
                                        "SVS", "SCS", "SOS",
                                        'S', "ingotDarkSteel", 'B', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', EIOCORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":vibrant_exchanger_easy"), null, new ItemStack(VIBRANT),
                                        "AEA", "ACA", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', EIOCORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier2_easy"), null, new ItemStack(EIOCORE_2),
                                        "PSP", "SDS", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', EIOCORE_1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier3_easy"), null, new ItemStack(EIOCORE_3),
                                        "DBD", "BVB", "DBD",
                                        'C', EIOCORE_2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":pulsating_exchanger_normal"), null, new ItemStack(PULSATING),
                                        "ICI", "PXP", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', EIOCORE_1, 'X', CONDUCTIVE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":electricalsteel_exchanger_normal"), null, new ItemStack(ELECTRICALSTEEL),
                                        "SCS", "DXD", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2, 'X', PULSATING
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":energetic_exchanger_normal"), null, new ItemStack(ENERGETIC),
                                        "ACA", "DXD", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2, 'X', ELECTRICALSTEEL
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":darksteel_exchanger_normal"), null, new ItemStack(DARKSTEEL),
                                        "SCS", "VXV", "SOS",
                                        'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', EIOCORE_3, 'X', ENERGETIC
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":vibrant_exchanger_normal"), null, new ItemStack(VIBRANT),
                                        "ACA", "EXE", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', EIOCORE_3, 'X', DARKSTEEL
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier2_normal"), null, new ItemStack(EIOCORE_2),
                                        "PSP", "DCD", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', EIOCORE_1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier3_normal"), null, new ItemStack(EIOCORE_3),
                                        "DBD", "VCV", "DBD",
                                        'C', EIOCORE_2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":pulsating_exchanger_hard"), null, new ItemStack(PULSATING),
                                        "IPI", "CXC", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', EIOCORE_1, 'X', CONDUCTIVE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":electricalsteel_exchanger_hard"), null, new ItemStack(ELECTRICALSTEEL),
                                        "SDS", "CXC", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2, 'X', PULSATING
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":energetic_exchanger_hard"), null, new ItemStack(ENERGETIC),
                                        "ADA", "CXC", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', EIOCORE_2, 'X', ELECTRICALSTEEL
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":darksteel_exchanger_hard"), null, new ItemStack(DARKSTEEL),
                                        "SVS", "CXC", "SOS",
                                        'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', EIOCORE_3, 'X', ENERGETIC
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":vibrant_exchanger_hard"), null, new ItemStack(VIBRANT),
                                        "AEA", "CXC", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', EIOCORE_3, 'X', DARKSTEEL
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier2_hard"), null, new ItemStack(EIOCORE_2),
                                        "PSP", "CDC", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', EIOCORE_1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":eio_core_tier3_hard"), null, new ItemStack(EIOCORE_3),
                                        "DCD", "CVC", "DCD",
                                        'C', EIOCORE_2, 'D', "ingotDarkSteel", 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                }
            }
        }

        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Data.THERMAL)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":leadstone_exchanger"), null, new ItemStack(LEADSTONE),
                                "LSL", "LCL", "LFL",
                                'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', TECORE_1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":te_core_tier1"), null, new ItemStack(TECORE_1),
                                "CLC", "LRL", "CLC",
                                'C', "gearCopper", 'L', "ingotLead", 'R', ThermalExpansionIntegration.bucketResonantEnder
                );
                switch (Config.thermalExpansionRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hardened_exchanger_easy"), null, new ItemStack(HARDENED),
                                        "IRI", "ICI", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', TECORE_1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":reinforced_exchanger_easy"), null, new ItemStack(REINFORCED),
                                        "ERE", "ECE", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', TECORE_2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":signalum_exchanger_easy"), null, new ItemStack(SIGNALUM),
                                        "SRS", "SCS", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', TECORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":resonant_exchanger_easy"), null, new ItemStack(RESONANT),
                                        "IRI", "ICI", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', TECORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier2_easy"), null, new ItemStack(TECORE_2),
                                        "BIB", "IGI", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', TECORE_1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier3_easy"), null, new ItemStack(TECORE_3),
                                        "LSL", "SGS", "LSL",
                                        'C', TECORE_2, 'S', "gearSignalum", 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hardened_exchanger_normal"), null, new ItemStack(HARDENED),
                                        "ICI", "RXR", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', TECORE_1, 'X', LEADSTONE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":reinforced_exchanger_normal"), null, new ItemStack(REINFORCED),
                                        "ECE", "RXR", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', TECORE_2, 'X', HARDENED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":signalum_exchanger_normal"), null, new ItemStack(SIGNALUM),
                                        "SCS", "RXR", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', TECORE_3, 'X', REINFORCED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":resonant_exchanger_normal"), null, new ItemStack(RESONANT),
                                        "ICI", "RXR", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', TECORE_3, 'X', SIGNALUM
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier2_normal"), null, new ItemStack(TECORE_2),
                                        "BIB", "GCG", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', TECORE_1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier3_normal"), null, new ItemStack(TECORE_3),
                                        "LSL", "GCG", "LSL",
                                        'C', TECORE_2, 'L', "gearLumium", 'S', "gearSignalum", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hardened_exchanger_hard"), null, new ItemStack(HARDENED),
                                        "IRI", "CXC", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', TECORE_1, 'X', LEADSTONE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":reinforced_exchanger_hard"), null, new ItemStack(REINFORCED),
                                        "ERE", "CXC", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', TECORE_2, 'X', HARDENED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":signalum_exchanger_hard"), null, new ItemStack(SIGNALUM),
                                        "SRS", "CXC", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', TECORE_3, 'X', REINFORCED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":resonant_exchanger_hard"), null, new ItemStack(RESONANT),
                                        "IRI", "CXC", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', TECORE_3, 'X', SIGNALUM
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier2_hard"), null, new ItemStack(TECORE_2),
                                        "BIB", "CGC", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', TECORE_1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":te_core_tier3_hard"), null, new ItemStack(TECORE_3),
                                        "LCL", "CGC", "LCL",
                                        'C', TECORE_2, 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                }
            }
        }

        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Data.MEK)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":basic_exchanger"), null, new ItemStack(BASIC),
                                "BTB", "BCB", "BTB",
                                'B', MekanismIntegration.circuitBasic, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":mek_core_tier1"), null, new ItemStack(MEKCORE_1),
                                "OSO", "SAS", "OSO",
                                'O', "ingotOsmium", 'S', "ingotSteel", 'A', "alloyAdvanced"
                );
                switch (Config.mekanismRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":advanced_exchanger_easy"), null, new ItemStack(ADVANCED),
                                        "ATA", "ACA", "ATA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":elite_exchanger_easy"), null, new ItemStack(ELITE),
                                        "EPE", "ECE", "ETE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ultimate_exchanger_easy"), null, new ItemStack(ULTIMATE),
                                        "UTU", "UCU", "UTU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', MEKCORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier2_easy"), null, new ItemStack(MEKCORE_2),
                                        "DGD", "GAG", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier3_easy"), null, new ItemStack(MEKCORE_3),
                                        "OIO", "IAI", "OIO",
                                        'O', "dustRefinedObsidian", 'I', "ingotRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":advanced_exchanger_normal"), null, new ItemStack(ADVANCED),
                                        "ACA", "TXT", "AAA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_2, 'X', BASIC
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":elite_exchanger_normal"), null, new ItemStack(ELITE),
                                        "ECE", "TXT", "EPE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_3, 'X', ADVANCED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ultimate_exchanger_normal"), null, new ItemStack(ULTIMATE),
                                        "UCU", "TXT", "UUU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', MEKCORE_3, 'X', ELITE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier2_normal"), null, new ItemStack(MEKCORE_2),
                                        "DGD", "ACA", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', MEKCORE_1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier3_normal"), null, new ItemStack(MEKCORE_3),
                                        "OAO", "ACA", "OAO",
                                        'C', MEKCORE_2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":advanced_exchanger_hard"), null, new ItemStack(ADVANCED),
                                        "ATA", "CXC", "ATA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_2, 'X', BASIC
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":elite_exchanger_hard"), null, new ItemStack(ELITE),
                                        "EPE", "CXC", "ETE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', MEKCORE_3, 'X', ADVANCED
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ultimate_exchanger_hard"), null, new ItemStack(ULTIMATE),
                                        "UTU", "CXC", "UTU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', MEKCORE_3, 'X', ELITE
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier2_hard"), null, new ItemStack(MEKCORE_2),
                                        "DGD", "CAC", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', MEKCORE_1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mek_core_tier3_hard"), null, new ItemStack(MEKCORE_3),
                                        "OCO", "CAC", "OCO",
                                        'C', MEKCORE_2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                }
            }
        }

        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Data.IE)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":lv_exchanger"), null, new ItemStack(LV),
                                "SLS", "SCS", "SLS",
                                'S', "blockSheetmetalCopper", 'L', ImmersiveEngineeringIntegration.lvCapacitor, 'C', IECORE_1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Data.MODID + ":ie_core_tier1"), null, new ItemStack(IECORE_1),
                                "CIC", "IBI", "CIC",
                                'C', ImmersiveEngineeringIntegration.lvWireCoil, 'I', ImmersiveEngineeringIntegration.ironMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketCreosote
                );
                switch (Config.immersiveEngineeringRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mv_exchanger_easy"), null, new ItemStack(MV),
                                        "SMS", "SCS", "SMS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', IECORE_2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hv_exchanger_easy"), null, new ItemStack(HV),
                                        "SHS", "SCS", "SHS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', IECORE_3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier2_easy"), null, new ItemStack(IECORE_2),
                                        "ESE", "SBS", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier3_easy"), null, new ItemStack(IECORE_3),
                                        "SHS", "HBH", "SHS",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mv_exchanger_normal"), null, new ItemStack(MV),
                                        "SCS", "MXM", "SSS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', IECORE_2, 'X', LV
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hv_exchanger_normal"), null, new ItemStack(HV),
                                        "SCS", "HXH", "SSS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', IECORE_3, 'X', MV
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier2_normal"), null, new ItemStack(IECORE_2),
                                        "ESE", "BCB", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', IECORE_1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier3_normal"), null, new ItemStack(IECORE_3),
                                        "SHS", "BCB", "SHS",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', IECORE_2
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":mv_exchanger_hard"), null, new ItemStack(MV),
                                        "SMS", "CXC", "SMS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', IECORE_2, 'X', LV
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":hv_exchanger_hard"), null, new ItemStack(HV),
                                        "SHS", "CXC", "SHS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', IECORE_3, 'X', MV
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier2_hard"), null, new ItemStack(IECORE_2),
                                        "ESE", "CBC", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', IECORE_1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Data.MODID + ":ie_core_tier3_hard"), null, new ItemStack(IECORE_3),
                                        "HCS", "CBC", "SCH",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', IECORE_2
                        );
                        break;
                    }
                }
            }
        }

        if (Config.specialModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Data.MODID + ":tuberous_exchanger"), null, new ItemStack(POTATO),
                            "PGP", "PEP", "PGP",
                            'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl"
            );
        }
    }

}
