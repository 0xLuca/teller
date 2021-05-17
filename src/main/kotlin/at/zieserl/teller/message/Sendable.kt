package at.zieserl.teller.message

import org.bukkit.command.CommandSender

interface Sendable {
    fun send(recepient: CommandSender)
}