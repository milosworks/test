package xyz.milosworks.untitled.fabric

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.ModInitializer
import xyz.milosworks.untitled.Untitled

object UntitledFabric : ModInitializer, ClientModInitializer {
    override fun onInitialize() {
        Untitled.init()
    }

    override fun onInitializeClient() {
        Untitled.initClient()
    }
} 