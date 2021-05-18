package at.zieserl.teller.provider

import at.zieserl.teller.message.Message
import at.zieserl.teller.message.delay.MessageDelayer
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class PropertiesMessageProvider(private val properties: Properties, private val messageDelayer: MessageDelayer) : MessageProvider {
    override fun provide(key: String): Message = Message(this, ChatColor.translateAlternateColorCodes('&', properties.getProperty(key, "Invalid message key $key!")), messageDelayer)

    companion object {
        fun fromPlugin(plugin: JavaPlugin, resourcePath: String) : PropertiesMessageProvider {
            plugin.saveResource(resourcePath, false)
            val properties = loadMessageProperties(plugin, resourcePath)
            return PropertiesMessageProvider(properties, MessageDelayer())
        }

        private fun loadMessageProperties(plugin: JavaPlugin, resourcePath: String) : Properties {
            val path = Paths.get(plugin.dataFolder.toString(), resourcePath)
            val properties = Properties()
            properties.load(Files.newInputStream(path))
            return properties
        }
    }
}