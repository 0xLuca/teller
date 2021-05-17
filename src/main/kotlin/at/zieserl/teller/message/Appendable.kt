package at.zieserl.teller.message

interface Appendable<T: Appendable<T>> {
    fun append(other: T?) : T
    @Suppress("UNCHECKED_CAST")
    fun appendTo(other: T) : T = other.append(this as? T)
}