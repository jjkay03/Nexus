package com.jjkay03.nexus

import org.bukkit.plugin.java.JavaPlugin

class Nexus : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: Nexus
    }

    // Plugin startup logic
    override fun onEnable() {
        INSTANCE = this

        // Startup info
        Utils.displayPluginWelcomeMessage("§9")
        logger.info("${description.name} is running!")
        logger.info("Plugin version: ${description.version}")

        // Config stuff
        saveDefaultConfig() // Save the default configuration if it doesn't exist
        reloadConfig() // Reload the configuration
    }

    // Plugin shutdown logic
    override fun onDisable() { }
}
