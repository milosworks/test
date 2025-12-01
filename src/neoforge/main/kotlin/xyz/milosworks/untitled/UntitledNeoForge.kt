package xyz.milosworks.untitled

import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent

@Mod(Untitled.ID)
class PhasorsNeoForge(modBus: IEventBus) {
    init {
        modBus.addListener<FMLConstructModEvent> {
            Untitled.init()
        }
        modBus.addListener<FMLClientSetupEvent> {
            Untitled.initClient()
        }
    }
}