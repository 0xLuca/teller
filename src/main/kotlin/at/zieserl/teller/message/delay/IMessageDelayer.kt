package at.zieserl.teller.message.delay

import at.zieserl.teller.message.Message
import org.bukkit.command.CommandSender

interface IMessageDelayer {
    fun isDelayPassed(commandSender: CommandSender, message: Message, delayMillis: Long): Boolean
    fun updateLastMessage(commandSender: CommandSender, message: Message)
}