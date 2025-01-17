package com.jjkay03.nexus.commands.cmd_nexusdev

import com.jjkay03.nexus.commands.ParentCommands
import com.jjkay03.nexus.commands.BaseParentCommand
import com.jjkay03.nexus.utility.Messages
import org.bukkit.entity.Player

class NexusDevCommand : BaseParentCommand(ParentCommands.NEXUS_DEV) {

    // Handle no arguments
    override fun noArgs(sender: Player) {
        sender.sendMessage(Messages.PREFIX_DEV + "§7TEMP MESSAGE: This is the main dev command")
    }

}