package com.jjkay03.nexus.commands

import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

abstract class BaseParentCommand(private val parentCommand: ParentCommands) : CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_NOT_PLAYER))
            return true
        }

        // Check if sender has permission to use parent command
        if (!sender.hasPermission(parentCommand.permission)) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_NO_PERMISSION))
            if (Saves.DEV_MODE) sender.sendMessage(Messages.PREFIX + "§7Missing permission: '${parentCommand.permission}'")
            return true
        }

        if (args.isEmpty()) {
            noArgs(sender)
            return true
        }

        // Search for subcommand end if its invalid
        val subCommand = SubCommands.entries.find {
            (it.parentCommands == parentCommand) &&
                    (it.command == args[0].lowercase() || it.aliases.contains(args[0].lowercase()))
        } ?: run {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_UNKNOWN_SUBCOMMAND))
            return true
        }

        // Check if sender has permission to use subcommand
        if (!sender.hasPermission(subCommand.permission)) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_NO_PERMISSION))
            if (Saves.DEV_MODE) sender.sendMessage(Messages.PREFIX + "§7Missing permission: '${subCommand.permission}'")
            return true
        }

        return subCommand.commandHandler.onCommand(sender, cmd, label, args.sliceArray(1 until args.size))
    }

    // Abstract function to handle parent command with no arguments
    abstract fun noArgs(sender: Player)

    // TAB COMPLETE
    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            return SubCommands.entries
                .filter { it.parentCommands == parentCommand }
                .flatMap { listOf(it.command) + it.aliases }
                .filter { it.isNotEmpty() && it.startsWith(args[0].lowercase()) }
        }

        val subCommand = SubCommands.entries.find {
            it.parentCommands == parentCommand &&
                    (it.command == args[0].lowercase() || it.aliases.contains(args[0].lowercase()))
        }

        return subCommand?.tabCompleter?.onTabComplete(sender, cmd, label, args.sliceArray(1 until args.size))
    }
}