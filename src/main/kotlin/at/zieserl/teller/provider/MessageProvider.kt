package at.zieserl.teller.provider

import at.zieserl.teller.message.Message

interface MessageProvider {
    fun provide(key: String) : Message
}