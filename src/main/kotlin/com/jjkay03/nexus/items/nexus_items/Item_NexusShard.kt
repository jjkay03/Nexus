package com.jjkay03.nexus.items.nexus_items

import com.jjkay03.nexus.items.BaseItem
import com.jjkay03.nexus.items.NexusItemModels
import org.bukkit.Material
import org.bukkit.inventory.ItemRarity

class Item_NexusShard: BaseItem (
    id = "nexus_shard",
    material = Material.AMETHYST_SHARD,
    itemModel = NexusItemModels.NEXUS_SHARD.namespacedKey,
    displayName = "Nexus Shard"
)