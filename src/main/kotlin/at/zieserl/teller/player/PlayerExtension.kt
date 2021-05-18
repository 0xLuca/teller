package at.zieserl.teller.player

import at.zieserl.teller.message.Message
import org.bukkit.command.CommandSender

/**
 * This extension creates an sendMessage method in CommandSender,
 * so that Message objects can be directly sent.
 */
fun CommandSender.sendMessage(message: Message) {
    message.send(this)
}