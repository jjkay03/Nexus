package com.jjkay03.nexus.commands

import com.jjkay03.nexus.utility.MessagesManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class NexusCommand: CommandExecutor {

    // Command
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(MessagesManager.getMessage("error.not-player-command"))
        }

        return true
    }
}