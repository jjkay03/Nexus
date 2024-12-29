package com.jjkay03.nexus

import jdk.jshell.execution.Util
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

        // Create all default files
        createDefaultFiles()
    }

    // Plugin shutdown logic
    override fun onDisable() { }

    // Function to create all default files
    private fun createDefaultFiles() {
        logger.info("Creating/checking plugin files")
        saveDefaultConfig()
        reloadConfig()
        Utils.createDirectory(Saves.DIR_PLAYERDATA)
        Utils.createFile(this, Saves.FILE_MESSAGES, Saves.FILE_NAME_MESSAGES)
    }
}
