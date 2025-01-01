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

        // Startup info
        Utils.displayPluginWelcomeMessage("§9")
        logger.info("${description.name} is running!")
        logger.info("Plugin version: ${description.version}")

        // Create all default files
        createDefaultFiles()

        // Load all variables in Saves class
        Saves()

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
        saveDefaultConfig()
        reloadConfig()
        Utils.createDirectory(Saves.DIR_PLAYERDATA)
        Utils.createFile(this, Saves.FILE_MESSAGES, Saves.FILE_NAME_MESSAGES)
        Utils.updateYamlDefaults(this, Saves.FILE_MESSAGES, Saves.FILE_NAME_MESSAGES)
    }
}
