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

package com.github.htgazurex1212.minecraftriichimahjong

import com.github.htgazurex1212.minecraftriichimahjong.MinecraftRiichiMahjong.LOGGER
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.loader.api.minecraft.ClientOnly
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer

@ClientOnly
object MinecraftRiichiMahjongClient : ClientModInitializer {
    override fun onInitializeClient(mod: ModContainer?) {
        LOGGER.info("Initializing client of ${mod?.metadata()?.name()} ${mod?.metadata()?.version()}")
    }
}