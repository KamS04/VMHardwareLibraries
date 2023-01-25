package ca.kam.vmhardwarelibraries.memory

interface Memory8 {
    fun getUByte(address: UShort): UByte

    fun setUByte(address: UShort, value: UByte): Boolean

    operator fun get(address: UShort): UByte = getUByte(address)

    operator fun set(address: UShort, value: UByte) = setUByte(address, value)
}