package com.github.htgazurex1212

import com.github.htgazurex1212.MinecraftRiichiMahjong.LOGGER
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer

object MinecraftRiichiMahjongClient : ClientModInitializer {
    override fun onInitializeClient(mod: ModContainer?) {
        LOGGER.info("Initializing client of ${mod?.metadata()?.name()} ${mod?.metadata()?.version()}")
    }
}