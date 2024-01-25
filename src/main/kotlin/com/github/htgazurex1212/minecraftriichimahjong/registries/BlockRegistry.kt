/* MinecraftRiichiMahjong: Riichi mahjong mod for Minecraft
 * Copyright (C) 2024 HTGAzureX1212.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.htgazurex1212.minecraftriichimahjong.registries

import com.github.htgazurex1212.minecraftriichimahjong.blocks.MahjongTable
import com.github.htgazurex1212.minecraftriichimahjong.utils.toMinecraftIdentifier
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object BlockRegistry {
    val MAHJONG_TABLE: MahjongTable = MahjongTable(
        QuiltBlockSettings.create()
            .nonOpaque()
            .pistonBehavior(PistonBehavior.IGNORE)
            .sounds(BlockSoundGroup.WOOD)
            .strength(1f)
    )

    fun registerBlocksAndBlockItems() {
        Registry.register(Registries.BLOCK, "mahjong_table".toMinecraftIdentifier(), MAHJONG_TABLE)

        Registry.register(Registries.ITEM, "mahjong_table".toMinecraftIdentifier(), BlockItem(MAHJONG_TABLE, QuiltItemSettings()))
    }
}