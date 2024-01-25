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

package com.github.htgazurex1212.minecraftriichimahjong.blocks

import com.github.htgazurex1212.minecraftriichimahjong.blockentities.MahjongTableBlockEntity
import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.EnumProperty
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MahjongTable(settings: Settings) : BlockWithEntity(settings) {
    init {
        defaultState = stateManager.defaultState.with(TABLE_PART, Part.BOTTOM_CENTER)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(TABLE_PART)
    }

    override fun createBlockEntity(blockPos: BlockPos, blockState: BlockState): BlockEntity? {
        if (blockState[TABLE_PART] != Part.BOTTOM_CENTER)
            return null

        return MahjongTableBlockEntity(blockPos, blockState)
    }

    override fun getPlacementState(context: ItemPlacementContext): BlockState? {
        val centerPosition = context.blockPos
        val placeable = peripheryAroundPos(centerPosition).all { context.world.getBlockState(it.second).canReplace(context) }

        return if (placeable) defaultState else null
    }

    @Suppress("DeprecatedCallableAddReplaceWith")
    @Deprecated("Deprecated in Java")
    override fun getRenderType(state: BlockState): BlockRenderType =
        if (state[TABLE_PART] != Part.BOTTOM_CENTER) BlockRenderType.MODEL else BlockRenderType.INVISIBLE

    override fun onPlaced(
        world: World,
        blockPos: BlockPos,
        blockState: BlockState,
        placer: LivingEntity?,
        itemStack: ItemStack
    ) {
        super.onPlaced(world, blockPos, blockState, placer, itemStack)

        if (world.isClient)
            return

        peripheryAroundPos(blockPos).forEach {
            (tablePart, position) -> world.setBlockState(position, blockState.with(TABLE_PART, tablePart))
        }
        world.updateNeighbors(blockPos, Blocks.AIR)
        blockState.updateNeighbors(world, blockPos, 3)
    }

    enum class Part : StringIdentifiable {
        BOTTOM_CENTER,
        TOP_CENTER,

        BOTTOM_EAST,
        BOTTOM_NORTH,
        BOTTOM_SOUTH,
        BOTTOM_NORTHEAST,
        BOTTOM_NORTHWEST,
        BOTTOM_SOUTHEAST,
        BOTTOM_SOUTHWEST,
        BOTTOM_WEST,

        TOP_EAST,
        TOP_NORTH,
        TOP_SOUTH,
        TOP_NORTHEAST,
        TOP_NORTHWEST,
        TOP_SOUTHEAST,
        TOP_SOUTHWEST,
        TOP_WEST;

        override fun asString(): String = name.lowercase()
    }

    companion object {
        val TABLE_PART: EnumProperty<Part> = EnumProperty.of("table_part", Part::class.java)

        fun peripheryAroundPos(position: BlockPos): List<Pair<Part, BlockPos>> = listOf(
            Part.BOTTOM_EAST      to position.east(),
            Part.BOTTOM_NORTH     to position.north(),
            Part.BOTTOM_SOUTH     to position.south(),
            Part.BOTTOM_WEST      to position.west(),
            Part.BOTTOM_NORTHEAST to position.north().east(),
            Part.BOTTOM_NORTHWEST to position.north().west(),
            Part.BOTTOM_SOUTHEAST to position.south().east(),
            Part.BOTTOM_SOUTHWEST to position.south().west(),
            Part.TOP_CENTER       to position.up(),
            Part.TOP_EAST         to position.east().up(),
            Part.TOP_NORTH        to position.north().up(),
            Part.TOP_SOUTH        to position.south().up(),
            Part.TOP_WEST         to position.west().up(),
            Part.TOP_NORTHEAST    to position.north().east().up(),
            Part.TOP_NORTHWEST    to position.north().west().up(),
            Part.TOP_SOUTHEAST    to position.south().east().up(),
            Part.TOP_SOUTHWEST    to position.south().west().up()
        )
    }
}