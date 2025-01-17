package com.jjkay03.nexus.commands.cmd_nexusdev.subs

import com.jjkay03.nexus.items.NexusItemModels
import com.jjkay03.nexus.items.nexus_items.Item_NexusShard
import com.jjkay03.nexus.utility.Messages
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Test1Command : CommandExecutor {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return true
        sender.sendMessage(Messages.PREFIX_DEV + "§aYou got a nexus shard")
        sender.inventory.addItem(Item_NexusShard().create())
        return true
    }
}