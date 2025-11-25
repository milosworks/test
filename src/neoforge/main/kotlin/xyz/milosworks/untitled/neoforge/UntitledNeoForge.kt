package xyz.milosworks.untitled.neoforge

import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent
import net.neoforged.neoforge.capabilities.Capabilities
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent
import net.neoforged.neoforge.fluids.capability.templates.FluidTank
import xyz.milosworks.untitled.Untitled

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