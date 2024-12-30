package com.jjkay03.nexus.commands.nexus_subs

import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class InfoCommand : CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage(Messages.PREFIX + "§aTEMP MESSAGE: §rThis is the nexus info command")
        return true
    }

    // TAB COMPLETE
    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            return listOf("temp1", "temp2").filter { it.startsWith(args[0].lowercase()) }
        }
        return null
    }

}