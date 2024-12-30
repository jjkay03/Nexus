package com.jjkay03.nexus.commands.nexus_subs

import com.jjkay03.nexus.utility.MessagesManager
import com.jjkay03.nexus.utility.MessagesPath
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class InfoCommand : CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(MessagesManager.getMessage(MessagesPath.ERROR_NOT_PLAYER_COMMAND))
        }

        sender.sendMessage("§9This is the nexus info command")

        return true
    }

    // TAB COMPLETE
    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            return listOf("test1", "test2").filter { it.startsWith(args[0].lowercase()) }
        }
        return null
    }

}