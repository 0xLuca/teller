package at.zieserl.teller.message.delay

import at.zieserl.teller.message.Message
import org.bukkit.command.CommandSender

/**
 * This class is used to check if an message is ready to be sent again
 * after a certain amount of time (delay)
 */
class MessageDelayer : IMessageDelayer {
    private val delayMap: HashMap<Pair<CommandSender, Message>, Long> = HashMap()

    @Synchronized override fun isDelayPassed(commandSender: CommandSender, message: Message, delayMillis: Long): Boolean
        = delayMap.getOrDefault(Pair(commandSender, message), 0) + delayMillis < System.currentTimeMillis()

    @Synchronized override fun updateLastMessage(commandSender: CommandSender, message: Message) {
        delayMap[Pair(commandSender, message)] = System.currentTimeMillis()
    }
}