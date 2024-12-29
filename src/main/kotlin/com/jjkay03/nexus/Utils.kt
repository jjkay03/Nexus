package com.jjkay03.nexus

import org.bukkit.Bukkit

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

}