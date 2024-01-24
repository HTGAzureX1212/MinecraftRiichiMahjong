package com.github.htgazurex1212

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object MinecraftRiichiMahjong : ModInitializer {
    val LOGGER: Logger = LogManager.getLogger()

    override fun onInitialize(mod: ModContainer?) {
        LOGGER.info("Initializing ${mod?.metadata()?.name()} ${mod?.metadata()?.version()}")
    }
}