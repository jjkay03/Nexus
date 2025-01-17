package com.jjkay03.nexus.items.crafting

import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.items.NexusItems
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey

class RegisterRecipes {
    init {
        NexusItems.entries.forEach { nexusItem ->
            val recipe = nexusItem.itemClass.recipe()?: return@forEach
            Bukkit.removeRecipe(NamespacedKey(Saves.NEXUS_NAMESPACE, nexusItem.itemClass.id)) // Remove recipe (in case it exist)
            Bukkit.addRecipe(recipe) // Register recipe
        }
    }
}
