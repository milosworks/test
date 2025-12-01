package xyz.milosworks.untitled

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer

object UntitledFabric : ModInitializer, ClientModInitializer {
    override fun onInitialize() {
        Untitled.init()
    }

    override fun onInitializeClient() {
        Untitled.initClient()
    }
} 