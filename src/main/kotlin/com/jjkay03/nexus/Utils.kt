package com.jjkay03.nexus

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

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


}