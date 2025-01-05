package com.jjkay03.nexus.commands.cmd_nexusdev.subs

import com.jjkay03.nexus.Nexus
import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.utility.Messages
import io.papermc.paper.datacomponent.DataComponentType
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

class Test1Command : CommandExecutor {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage(Messages.PREFIX + "§aTEMP MESSAGE: §rTest 1")
        if (sender !is Player) return true
        sender.inventory.addItem(createTestItem())
        return true
    }

    private fun createTestItem(): ItemStack {
        val item = ItemStack(Material.AMETHYST_SHARD)
        val meta = item.itemMeta
        meta.displayName(Component.text("§fNexus Shard"))
        meta.itemModel = NamespacedKey(Nexus.INSTANCE, "nexus_shard")
        item.itemMeta = meta
        return item
    }

}