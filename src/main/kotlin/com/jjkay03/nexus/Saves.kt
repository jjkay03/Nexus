package com.jjkay03.nexus

import java.io.File

class Saves {
    companion object {
        var DEV_MODE = true

        // DIRECTORIES
        val DIR_MAIN_PLUGIN = File("plugins/Nexus")
        val DIR_PLAYERDATA = File(DIR_MAIN_PLUGIN, "playerdata")
        // FILES
        const val FILE_NAME_MESSAGES = "messages.yml"
        val FILE_MESSAGES = File(DIR_MAIN_PLUGIN, FILE_NAME_MESSAGES)

        // PERMISSIONS
        const val PERM_ADMIN = "nexus.admin"
        const val PERM_COMMAND = "nexus.command"
    }
}