package at.zieserl.teller.provider

import at.zieserl.teller.message.Message
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class PropertiesMessageProvider(private val properties: Properties) : MessageProvider {
    companion object {
        fun fromPlugin(plugin: JavaPlugin, resourcePath: String) : PropertiesMessageProvider {
            plugin.saveResource(resourcePath, false)
            val properties = loadMessageProperties(plugin, resourcePath);
            return PropertiesMessageProvider(properties)
        }

        private fun loadMessageProperties(plugin: JavaPlugin, resourcePath: String) : Properties{
            val path = Paths.get(plugin.dataFolder.toString(), resourcePath)
            val properties = Properties()
            properties.load(Files.newInputStream(path));
            return properties;
        }
    }

    override fun provide(key: String): Message = Message(this, properties.getProperty(key, "Invalid message key $key!"))
}