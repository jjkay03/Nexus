package com.jjkay03.nexus.items.nexus_items

import com.jjkay03.nexus.Saves
import com.jjkay03.nexus.items.BaseItem
import com.jjkay03.nexus.items.NexusItemModels
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapedRecipe

class Item_NexusShard: BaseItem (
    id = "nexus_shard",
    material = Material.AMETHYST_SHARD,
    itemModel = NexusItemModels.NEXUS_SHARD.namespacedKey,
    displayName = "Nexus Shard"
) {
    // TODO: TEMP RECIPE / REMOVE THAT LATER / Kept here for future recipe item
    override fun recipe(): Recipe {
        return ShapedRecipe(
            NamespacedKey(Saves.NEXUS_NAMESPACE, id),
            create(),
        ).apply {
            shape(
                "AAA",
                "ABA",
                "AAA"
            )
            setIngredient('A', Material.AMETHYST_SHARD)
            setIngredient('B', Material.LAPIS_LAZULI)
        }
    }
}