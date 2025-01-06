package com.jjkay03.nexus

import com.jjkay03.nexus.commands.ParentCommands
import com.jjkay03.nexus.commands.cmd_nexus.NexusCommand
import com.jjkay03.nexus.commands.cmd_nexusadmin.NexusAdminCommand
import com.jjkay03.nexus.commands.cmd_nexusdev.NexusDevCommand
import org.bukkit.plugin.java.JavaPlugin

class Nexus : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: Nexus
    }

    // Plugin startup logic
    override fun onEnable() {
        INSTANCE = this

        // Startup logic
        createDefaultFiles() // Create all default files
        Saves() // Load all variables in Saves class

        // Startup info
        Utils.displayPluginWelcomeMessage("§9")
        Utils.devmodeConsoleWarning()
        logger.info("${description.name} is running!")
        logger.info("Plugin version: ${description.version}")

        // COMMANDS
        getCommand(ParentCommands.NEXUS.command)?.setExecutor(NexusCommand())
        getCommand(ParentCommands.NEXUS_ADMIN.command)?.setExecutor(NexusAdminCommand())
        if (Saves.DEV_MODE) getCommand(ParentCommands.NEXUS_DEV.command)?.setExecutor(NexusDevCommand())

    }

    // Plugin shutdown logic
    override fun onDisable() { }

    // Function to create all default files
    private fun createDefaultFiles() {
        logger.info("Creating/checking plugin files...")
        // Create config
        saveDefaultConfig()
        reloadConfig()
        // Create dir/files
        Utils.createDirectory(Saves.DIR_PLAYERDATA)
        Utils.createFile(this, Saves.FILE_MESSAGES, Saves.FILE_NAME_MESSAGES)
        // Update yml files (if missing keys)
        Utils.updateYamlDefaults(this, Saves.FILE_CONFIG, Saves.FILE_NAME_CONFIG)
        Utils.updateYamlDefaults(this, Saves.FILE_MESSAGES, Saves.FILE_NAME_MESSAGES)
    }
}
