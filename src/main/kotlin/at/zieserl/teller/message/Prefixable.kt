package at.zieserl.teller.message

interface Prefixable<T> {
    fun prefixed() : T
}