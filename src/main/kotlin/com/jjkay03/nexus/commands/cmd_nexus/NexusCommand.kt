package com.jjkay03.nexus.commands.cmd_nexus

import com.jjkay03.nexus.commands.ParentCommands
import com.jjkay03.nexus.commands.BaseParentCommand
import com.jjkay03.nexus.utility.Messages
import org.bukkit.entity.Player

class NexusCommand : BaseParentCommand(ParentCommands.NEXUS) {

    // Handle no arguments
    override fun noArgs(sender: Player) {
        sender.sendMessage(Messages.PREFIX + "§7TEMP MESSAGE: This is the main nexus command")
    }

}