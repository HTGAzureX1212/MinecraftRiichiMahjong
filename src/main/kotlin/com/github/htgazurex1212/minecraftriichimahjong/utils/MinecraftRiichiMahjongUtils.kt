package com.github.htgazurex1212.minecraftriichimahjong.utils

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier

const val MOD_IDENTIFIER = "minecraft_riichi_mahjong"

fun String.toMinecraftIdentifier(): Identifier = Identifier(MOD_IDENTIFIER, this)
