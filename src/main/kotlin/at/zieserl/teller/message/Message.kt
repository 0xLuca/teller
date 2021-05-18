package at.zieserl.teller.message

import at.zieserl.teller.message.delay.MessageDelayer
import at.zieserl.teller.provider.MessageProvider
import org.bukkit.command.CommandSender

class Message(private val provider: MessageProvider, private var message: String, private val messageDelayer: MessageDelayer) : Prefixable<Message>, Appendable<Message>, DelayedSendable {
    override fun prefixed(): Message {
        return appendTo(provider.provide("prefix"))
    }

    override fun append(other: Message?): Message {
        this.message += other?.message ?: ""
        return this
    }

    override fun send(recepient: CommandSender) {
        recepient.sendMessage(message)
    }

    override fun sendDelayed(recepient: CommandSender, delayMillis: Long) {
        if (messageDelayer.isDelayPassed(recepient, this, delayMillis)) {
            send(recepient)
            messageDelayer.updateLastMessage(recepient, this)
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Message && other.message == message
    }

    override fun hashCode(): Int {
        return message.hashCode()
    }
}