package com.jjkay03.nexus.spells

import org.bukkit.entity.Player

abstract class BaseSpell(
    val id: String,
    val name: String,
    val type: SpellType? = SpellType.NONE,
    val difficulty: SpellDifficulty? = SpellDifficulty.NOVICE,
    var castingPlayer: Player? = null,
    val targetPlayers: List<Player>? = null
) {
    // Abstract function to add logic for spell
    abstract fun execute()
}