package com.github.htgazurex1212

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object MinecraftRiichiMahjong : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("Minecraft Riichi Mahjong")

    override fun onInitialize(mod: ModContainer?) {
        LOGGER.info("Initializing ${mod?.metadata()?.name()} ${mod?.metadata()?.version()}")
    }
}