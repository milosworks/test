package xyz.milosworks.untitled.platform

import net.minecraft.network.chat.Component

expect class Platform(num: Int, anything: (Component) -> Boolean) {
    fun getPlatform(): String
}