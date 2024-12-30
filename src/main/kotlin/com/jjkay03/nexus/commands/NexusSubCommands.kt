package com.jjkay03.nexus.commands

import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter

enum class NexusSubCommands(
    val command: String,
    val aliases: List<String>,
    val permission: String,
    val commandHandler: CommandExecutor,
    val tabCompleter: TabCompleter
) {

//    INFO (
//        "info",
//        listOf(""),
//        "nexus.command.info",
//
//    )

}