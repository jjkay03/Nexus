package com.jjkay03.nexus.utility

import com.jjkay03.nexus.Saves
import org.bukkit.configuration.file.YamlConfiguration

class Messages {
    companion object {
        private val MESSAGES_CONFIG = YamlConfiguration.loadConfiguration(Saves.FILE_MESSAGES)

        // Function to get message from path
        fun getMessage(path: String, replacements: Map<String, String> = emptyMap()): String {
            var message = MESSAGES_CONFIG.getString(path) ?: "§4Message not found in ${Saves.FILE_NAME_MESSAGES}: $path"
            replacements.forEach { (key, value) -> message = message.replace("%$key%", value) }
            return message
        }

        // Messages paths
        val PREFIX = getMessage("prefix")

        const val ERROR_COMMAND_NOT_PLAYER = "error.command.not-player"
        const val ERROR_COMMAND_NO_PERMISSION = "error.command.no-permission"
        const val ERROR_COMMAND_UNKNOWN_SUBCOMMAND = "error.command.unknown-subcommand"
    }
}