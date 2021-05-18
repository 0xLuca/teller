package at.zieserl.teller.message.delay

import at.zieserl.teller.message.Message
import org.bukkit.command.CommandSender

class MessageDelayer : IMessageDelayer {
    private val delayMap: HashMap<Pair<CommandSender, Message>, Long> = HashMap()

    override fun isDelayPassed(commandSender: CommandSender, message: Message, delayMillis: Long): Boolean
        = delayMap.getOrDefault(Pair(commandSender, message), 0) < System.currentTimeMillis() + delayMillis

    override fun updateLastMessage(commandSender: CommandSender, message: Message) {
        delayMap[Pair(commandSender, message)] = System.currentTimeMillis()
    }
}