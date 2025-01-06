package com.jjkay03.nexus.items.nexus_items

import com.jjkay03.nexus.items.BaseItem
import com.jjkay03.nexus.items.NexusItemModels
import org.bukkit.Material

class Item_DebugItem: BaseItem(
    id = "debug_item",
    material = Material.AMETHYST_SHARD,
    itemModel = NexusItemModels.DEBUG_ITEM.namespacedKey,
    displayName = "Debug Item"
)