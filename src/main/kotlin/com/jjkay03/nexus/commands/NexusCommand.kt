package com.jjkay03.nexus.commands

import com.jjkay03.nexus.utility.MessagesManager
import com.jjkay03.nexus.utility.MessagesPath
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class NexusCommand: CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(MessagesManager.getMessage(MessagesPath.ERROR_NOT_PLAYER_COMMAND))
        }

        // If no arguments, show main command info
        if (args.isEmpty()) {
            sender.sendMessage("§9This is the main nexus command")
            return true
        }

        // Find the subcommand
        val subCommand = NexusSubCommands.entries.find {
            it.command == args[0].lowercase() || it.aliases.contains(args[0].lowercase())
        } ?: run {
            sender.sendMessage("§cUnknown subcommand!")
            return true
        }

        // Execute the subcommand with remaining arguments
        return subCommand.commandHandler.onCommand(
            sender,
            cmd,
            label,
            args.sliceArray(1 until args.size)
        )

    }

    // TAB COMPLETE
    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            val completions = mutableListOf<String>()

            // Add all sub commands and their aliases
            NexusSubCommands.entries.forEach { subCmd ->
                completions.add(subCmd.command)
                completions.addAll(subCmd.aliases.filter { it.isNotEmpty() })
            }

            // Filter based on what the player has typed so far
            return completions.filter { it.startsWith(args[0].lowercase()) }
        }

        // If on a subcommand, use its tab completer if it exists
        val subCommand = NexusSubCommands.entries.find {
            it.command == args[0].lowercase() || it.aliases.contains(args[0].lowercase())
        }

        return subCommand?.tabCompleter?.onTabComplete(sender, cmd, label, args.sliceArray(1 until args.size))
    }
}