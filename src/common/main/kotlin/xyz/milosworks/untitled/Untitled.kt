package xyz.milosworks.untitled

import com.mojang.logging.LogUtils
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import xyz.milosworks.untitled.platform.Platform

object Untitled {
    const val ID = "untitled"

    val LOGGER: Logger = LogUtils.getLogger()

    fun init() {
        val myPlatform = Platform(1) { c -> true }
        println("Im running on ${myPlatform.getPlatform()}")
    }

    fun initClient() {

    }

    operator fun get(path: String): ResourceLocation =
        ResourceLocation.fromNamespaceAndPath(ID, path)
}