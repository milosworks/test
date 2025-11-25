package xyz.milosworks.untitled.fabric.platform

import net.minecraft.network.chat.Component

actual class Platform actual constructor(num: Int, anything: (Component) -> Boolean) {
    fun getPlatform(): String {
        return "fabric"
    }
}