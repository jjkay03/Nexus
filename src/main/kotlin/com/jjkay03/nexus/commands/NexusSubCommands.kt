package com.jjkay03.nexus.commands

import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.commands.nexus_subs.InfoCommand
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter

enum class NexusSubCommands(
    val command: String,
    val aliases: List<String>,
    val permission: String,
    val commandHandler: CommandExecutor,
    val tabCompleter: TabCompleter? = null
) {

    INFO (
        "info",
        listOf("inf"),
        "${Saves.PERM_COMMAND}.info",
        InfoCommand(),
        InfoCommand()
    )

}