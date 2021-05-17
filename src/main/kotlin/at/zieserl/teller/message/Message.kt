package at.zieserl.teller.message

import at.zieserl.teller.provider.MessageProvider
import org.bukkit.command.CommandSender

class Message(private val provider: MessageProvider, private var message: String) : Prefixable<Message>, Appendable<Message>, Sendable {
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
}