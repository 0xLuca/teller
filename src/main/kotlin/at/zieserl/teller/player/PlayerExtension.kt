package at.zieserl.teller.player

import at.zieserl.teller.message.Message
import org.bukkit.command.CommandSender

fun CommandSender.sendMessage(message: Message) {
    message.send(this);
}