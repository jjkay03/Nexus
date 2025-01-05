package com.jjkay03.nexus.commands.cmd_nexusdev.subs

import com.jjkay03.nexus.items.nexus_items.Item_NexusShard
import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class Test2Command : CommandExecutor {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return true
        if (Item_NexusShard().isItem(sender.inventory.itemInMainHand)) {
            sender.sendMessage(Messages.PREFIX + "§aItem you are holding is a Nexus Shard")
        } else {
            sender.sendMessage(Messages.PREFIX + "§cItem you are holding is not a Nexus Shard")
        }
        return true
    }

}