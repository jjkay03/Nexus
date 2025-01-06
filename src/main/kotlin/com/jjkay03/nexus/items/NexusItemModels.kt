package com.jjkay03.nexus.items

import com.jjkay03.nexus.Saves
import org.bukkit.NamespacedKey

enum class NexusItemModels (val namespacedKey: NamespacedKey) {
    DEBUG_ITEM(NamespacedKey(Saves.NEXUS_NAMESPACE, "debug_item")),
    NEXUS_SHARD(NamespacedKey(Saves.NEXUS_NAMESPACE, "nexus_shard"))
}