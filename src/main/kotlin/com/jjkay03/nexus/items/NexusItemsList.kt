package com.jjkay03.nexus.items

import org.reflections.Reflections

class NexusItemsList {


    init {
        // Scan package for all items
        val packageName = "com.jjkay03.nexus.items.nexus_items"
        val reflections = Reflections(packageName)

        reflections.getSubTypesOf(BaseItem::class.java).forEach { itemClass ->
            try {
                val instance = itemClass.getDeclaredConstructor().newInstance()
                ITEMS[instance.id] = instance
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        val ITEMS = mutableMapOf<String, BaseItem>()

        fun getItem(id: String): BaseItem? = ITEMS[id]
        fun getAllIds(): List<String> = ITEMS.keys.toList()
    }


}