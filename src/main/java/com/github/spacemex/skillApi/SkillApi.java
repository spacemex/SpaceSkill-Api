package com.github.spacemex.skillApi;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SkillApi extends JavaPlugin {

    @Override
    public void onEnable(){
        Logger logger = getLogger();
        logger.info("SkillAPI has been enabled!");
    }
}
