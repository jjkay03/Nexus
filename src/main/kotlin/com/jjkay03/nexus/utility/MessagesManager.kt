package com.jjkay03.nexus.utility

import com.jjkay03.nexus.Saves
import org.bukkit.configuration.file.YamlConfiguration

class MessagesManager {
    companion object {
        val MESSAGES_CONFIG = YamlConfiguration.loadConfiguration(Saves.FILE_MESSAGES)
        val PREFIX = getMessage(MessagesPath.PREFIX)

        fun getMessage(path: String, replacements: Map<String, String> = emptyMap()): String {
            var message = MESSAGES_CONFIG.getString(path) ?: "Message not found: $path"
            replacements.forEach { (key, value) -> message = message.replace("%$key%", value) }
            return message
        }
    }
}

class MessagesPath {
    companion object {
        const val PREFIX = "prefix"
        const val ERROR_NOT_PLAYER_COMMAND = "error.not-player-command"
    }
}