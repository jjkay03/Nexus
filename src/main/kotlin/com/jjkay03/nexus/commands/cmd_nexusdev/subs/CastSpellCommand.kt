package com.jjkay03.nexus.commands.cmd_nexusdev.subs

import com.jjkay03.nexus.items.nexus_items.Item_NexusShard
import com.jjkay03.nexus.spells.nexus_spells.Spell_DebugSpell
import com.jjkay03.nexus.utility.Messages
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CastSpellCommand : CommandExecutor {

    // COMMAND
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return true
        sender.sendMessage(Messages.PREFIX_DEV + "§aCasting Spell ✨")

        // Cast spell
        val spell = Spell_DebugSpell()
        spell.castingPlayer = sender
        spell.execute()

        return true
    }
}