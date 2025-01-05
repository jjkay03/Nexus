package com.jjkay03.nexus.commands.cmd_nexusadmin.subs

import com.jjkay03.nexus.items.NexusItemsList
import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class GiveItemCommand: CommandExecutor, TabCompleter {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {

        // End if sender not player
        if (sender !is Player) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_NOT_PLAYER))
            return true
        }

        // End if no item provided
        if (args.isEmpty()) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.ERROR_COMMAND_USAGE, mapOf("usage" to "/nexusadmin giveitem <item>")))
            return true
        }

        val itemId = args[0]
        val item = NexusItemsList.getItem(itemId)

        // End if item is invalid
        if (item == null) {
            sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.COMMAND_GIVEITEM_INVALID_ITEM))
            sender.sendMessage(Messages.PREFIX + "§7Item ID's: " + NexusItemsList.getAllIds().toString())
            return true
        }

        sender.inventory.addItem(item.create())
        sender.sendMessage(Messages.PREFIX + Messages.getMessage(Messages.COMMAND_GIVEITEM_GIVE_ITEM, mapOf("item" to item.id)))
        return true
    }

    // TAB COMPLETE
    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): List<String>? {
        return NexusItemsList.getAllIds().filter { it.startsWith(args[0].lowercase()) }
    }

}