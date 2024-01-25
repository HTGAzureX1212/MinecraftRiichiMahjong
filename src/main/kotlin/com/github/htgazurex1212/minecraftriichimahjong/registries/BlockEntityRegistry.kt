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

import com.github.htgazurex1212.minecraftriichimahjong.blockentities.MahjongTableBlockEntity
import com.github.htgazurex1212.minecraftriichimahjong.utils.toMinecraftIdentifier
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object BlockEntityRegistry {
    val MAHJONG_TABLE: BlockEntityType<MahjongTableBlockEntity> =
        BlockEntityType.Builder.create(::MahjongTableBlockEntity, BlockRegistry.MAHJONG_TABLE).build(null)

    fun registerBlockEntities() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, "mahjong_table".toMinecraftIdentifier(), MAHJONG_TABLE)
    }
}