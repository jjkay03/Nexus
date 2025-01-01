package com.jjkay03.nexus.commands.cmd_nexusadmin

import com.jjkay03.nexus.commands.ParentCommands
import com.jjkay03.nexus.commands.BaseParentCommand
import com.jjkay03.nexus.utility.Messages
import org.bukkit.entity.Player

class NexusAdminCommand : BaseParentCommand(ParentCommands.NEXUS_ADMIN) {

    // Handle no arguments
    override fun noArgs(sender: Player) {
        sender.sendMessage(Messages.PREFIX + "§aTEMP MESSAGE: §rThis is the main admin command")
    }

}