package at.zieserl.teller.message

import org.bukkit.command.CommandSender

interface DelayedSendable : Sendable {
    fun sendDelayed(recepient: CommandSender, delayMillis: Long)
}