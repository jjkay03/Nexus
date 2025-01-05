package com.jjkay03.nexus

import org.bukkit.NamespacedKey
import java.io.File

class Saves {
    companion object {
        var DEV_MODE = false // Get from config

        // PERMISSIONS
        const val PERM_ADMIN = "nexus.admin"
        const val PERM_COMMAND = "nexus.command"

        // DIRECTORIES
        val DIR_MAIN_PLUGIN = File("plugins/Nexus")
        val DIR_PLAYERDATA = File(DIR_MAIN_PLUGIN, "playerdata")

        // FILES
        const val FILE_NAME_CONFIG = "config.yml"; val FILE_CONFIG = File(DIR_MAIN_PLUGIN, FILE_NAME_CONFIG)
        const val FILE_NAME_MESSAGES = "messages.yml"; val FILE_MESSAGES = File(DIR_MAIN_PLUGIN, FILE_NAME_MESSAGES)
    }

    init {
        // Variables from config
        DEV_MODE = Nexus.INSTANCE.config.getBoolean("dev-mode")
    }
}