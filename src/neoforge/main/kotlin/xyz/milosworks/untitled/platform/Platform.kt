package xyz.milosworks.untitled.platform

import net.minecraft.network.chat.Component

actual class Platform actual constructor(num: Int, anything: (Component) -> Boolean) {
    actual fun getPlatform() = "neoforge"
}