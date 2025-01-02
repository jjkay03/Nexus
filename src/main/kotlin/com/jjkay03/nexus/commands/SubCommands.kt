package com.jjkay03.nexus.commands

import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.commands.cmd_nexus.subs.*
import com.jjkay03.nexus.commands.cmd_nexusdev.subs.*
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter

enum class SubCommands(
    val parentCommands: ParentCommands,
    val command: String,
    val aliases: List<String>,
    val permission: String,
    val commandHandler: CommandExecutor,
    val tabCompleter: TabCompleter? = null
) {

    // --- NEXUS COMMANDS -----------------------------------------------------------------------

    INFO (
        ParentCommands.NEXUS,
        "info",
        listOf(""),
        "${Saves.PERM_COMMAND}.info",
        InfoCommand(),
        InfoCommand()
    ),

    // --- NEXUS DEV COMMANDS -------------------------------------------------------------------

    DEV_TEST_1 (
        ParentCommands.NEXUS_DEV,
        "test1",
        listOf(""),
        "",
        Test1Command()
    ),

    DEV_TEST_2 (
        ParentCommands.NEXUS_DEV,
        "test2",
        listOf(""),
        "",
        Test2Command()
    );

}