package com.jjkay03.nexus.spells.nexus_spells

import com.jjkay03.nexus.spells.BaseSpell
import org.bukkit.Particle
import org.bukkit.Sound

class Spell_DebugSpell : BaseSpell (
    id = "debug_spell",
    name = "Debug Spell"
) {
    override fun execute() {
        // End if castingPlayer is null
        val castingPlayer = this.castingPlayer ?: return

        // Summon particles at castingPlayer
        castingPlayer.world.spawnParticle(
            Particle.TRIAL_SPAWNER_DETECTION,
            castingPlayer.location.add(0.0, 1.0, 0.0),
            30,
            0.5, 1.0, 0.5,
            0.01
            )

        // Play sound at castingPlayer
        castingPlayer.world.playSound(
            castingPlayer.location,
            Sound.BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE,
            1.0f, 1.0f
        )
    }
}