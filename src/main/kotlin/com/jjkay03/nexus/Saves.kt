package com.jjkay03.nexus

import java.io.File

class Saves {
    companion object {
        // Directories
        val DIR_MAIN_PLUGIN = File("plugins/Nexus")
        val DIR_PLAYERDATA = File(DIR_MAIN_PLUGIN, "playerdata")
        // Files
        const val FILE_NAME_MESSAGES = "messages.yml"
        val FILE_MESSAGES = File(DIR_MAIN_PLUGIN, FILE_NAME_MESSAGES)

    }
}