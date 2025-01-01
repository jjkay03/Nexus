package com.jjkay03.nexus.commands.cmd_nexusdev.subs

import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class Test2Command : CommandExecutor {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage(Messages.PREFIX + "§aTEMP MESSAGE: §rTest 2")
        return true
    }

}