package com.jjkay03.nexus

import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    // Function to display plugin welcome message
    fun displayPluginWelcomeMessage(color: String) {
        val welcomeMessage = listOf(
            "${color}  _   _                      ",
            "${color} | \\ | |                     ",
            "${color} |  \\| | _____  ___   _ ___  ",
            "${color} | . ` |/ _ \\ \\/ / | | / __|",
            "${color} | |\\  |  __/>  <| |_| \\__ \\ ",
            "${color} |_| \\_|\\___/_/\\_\\\\__,_|___/ ",
            "${color}                             ",
        )
        welcomeMessage.forEach { line -> Bukkit.getConsoleSender().sendMessage(line) }
    }

    // Function to show a warning about nexus dev mode being enabled
    fun devmodeConsoleWarning() {
        if (!Saves.DEV_MODE) return // End if devmode is disabled
        val warningMessage = " §4[NEXUS DEV MODE IS ENABLED]"
        Bukkit.getConsoleSender().sendMessage(warningMessage)
        Bukkit.getConsoleSender().sendMessage("")
    }

    // Function to create a file when it doesn't already exist
    fun createFile(plugin: JavaPlugin, file: File, resourcePath: String? = null) {
        if (file.exists()) return
        file.parentFile.mkdirs()
        if (resourcePath != null) plugin.saveResource(resourcePath, false)
        else file.createNewFile()
    }

    // Function to create a directory when it doesn't already exist
    fun createDirectory(directory: File) {
        if (!directory.exists()) directory.mkdirs()
    }

    // Function that compare local yml with default yml and add missing keys
    fun updateYamlDefaults(plugin: JavaPlugin, file: File, resourcePath: String) {
        val currentConfig = YamlConfiguration.loadConfiguration(file)
        val defaultConfig = YamlConfiguration.loadConfiguration(InputStreamReader(plugin.getResource(resourcePath) ?: return))
        var updated = false; var updated_keys_count = 0

        for (key in defaultConfig.getKeys(true)) if (!currentConfig.contains(key)) {
            currentConfig.set(key, defaultConfig.get(key))
            updated = true; updated_keys_count++
        }

        // End if no update
        if (!updated) return

        // Save changes
        currentConfig.save(file)

        // Add updated file date and version comment
        val timestamp = SimpleDateFormat("dd/MM/yy hh:mm a").format(Date())
        file.appendText("\n\n# FILE UPDATE: $updated_keys_count missing keys | $timestamp | Nexus V${Nexus.INSTANCE.description.version}")

        Nexus.INSTANCE.logger.warning("Updated $resourcePath with missing $updated_keys_count keys")
    }


}