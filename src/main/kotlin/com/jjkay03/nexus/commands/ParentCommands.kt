package com.jjkay03.nexus.commands

import com.jjkay03.nexus.Saves


enum class ParentCommands(
    val command: String,
    val permission: String,
) {

    NEXUS(
        "nexus",
        Saves.PERM_COMMAND
    ),

    NEXUS_ADMIN(
        "nexusadmin",
        Saves.PERM_ADMIN
    ),

    NEXUS_DEV(
        "nexusdev",
        Saves.PERM_ADMIN
    )
}