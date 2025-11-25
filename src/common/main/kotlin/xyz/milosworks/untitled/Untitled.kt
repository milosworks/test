package xyz.milosworks.untitled

import com.mojang.logging.LogUtils
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger

object Untitled {
    const val ID = "untitled"

    val LOGGER: Logger = LogUtils.getLogger()

    fun init() {
    
    }

    fun initClient() {

    }

    operator fun get(path: String): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(ID, path)
}