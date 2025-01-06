package com.jjkay03.nexus.items.crafting

import com.jjkay03.nexus.items.NexusItems
import org.bukkit.Bukkit

class RegisterRecipes {
    init {
        NexusItems.entries.forEach { nexusItem ->
            val recipe = nexusItem.itemClass.recipe()
            if (recipe != null) Bukkit.addRecipe(recipe)
        }
    }
}
