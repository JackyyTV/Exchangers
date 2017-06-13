package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "config";

    public static int woodenExchangerMaxDamage;
    public static int stoneExchangerMaxDamage;
    public static int goldenExchangerMaxDamage;
    public static int ironExchangerMaxDamage;
    public static int diamondExchangerMaxDamage;
    public static int emeraldExchangerMaxDamage;
    public static int obsidianExchangerMaxDamage;

    public static void readConfig(){
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e) {
            Exchangers.logger.error("ERROR LOADING CONFIG", e);
        } finally {
            if(cfg.hasChanged()){
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg){
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Exchangers Config");

        woodenExchangerMaxDamage = cfg.getInt("Wooden Exchanger Max Durability", CATEGORY_GENERAL, 512, 1, 2147483647, "Set the durability for Wooden Exchanger");
        stoneExchangerMaxDamage = cfg.getInt("Stone Exchanger Max Durability", CATEGORY_GENERAL, 1024, 1, 2147483647, "Set the durability for Stone Exchanger");
        goldenExchangerMaxDamage = cfg.getInt("Golden Exchanger Max Durability", CATEGORY_GENERAL, 768, 1, 2147483647, "Set the durability for Golden Exchanger");
        ironExchangerMaxDamage = cfg.getInt("Iron Exchanger Max Durability", CATEGORY_GENERAL, 2048, 1, 2147483647, "Set the durability for Iron Exchanger");
        diamondExchangerMaxDamage = cfg.getInt("Diamond Exchanger Max Durability", CATEGORY_GENERAL, 4096, 1, 2147483647, "Set the durability for Diamond Exchanger");
        emeraldExchangerMaxDamage = cfg.getInt("Emerald Exchanger Max Durability", CATEGORY_GENERAL, 8192, 1, 2147483647, "Set the durability for Emerald Exchanger");
        obsidianExchangerMaxDamage = cfg.getInt("Obsidian Exchanger Max Durability", CATEGORY_GENERAL, 16384, 1, 2147483647, "Set the durability for Obsidian Exchanger");

    }

}
