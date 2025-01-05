package com.jjkay03.nexus.items

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack

abstract class BaseItem(
    val id: String,
    private val material: Material,
    private val itemModel: NamespacedKey? = null,
    private val displayName: String? = null,
    private val lore: List<String>? = null,
    private val rarity: ItemRarity? = null
) {

    // Function to create the item
    fun create(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta
        if (itemModel != null) meta.itemModel = itemModel
        if (displayName != null) meta.displayName(Component.text("§f$displayName"))
        if (lore != null) meta.lore(lore.map { Component.text(it) })
        if (rarity != null) meta.setRarity(rarity)
        item.itemMeta = meta
        return item
    }

    // Function that checks if item is the item created
    fun isItem(item: ItemStack?): Boolean {
        if (item == null) return false
        if (item.type != material) return false
        if (item.itemMeta.itemModel != itemModel) return false
        return true
    }
}