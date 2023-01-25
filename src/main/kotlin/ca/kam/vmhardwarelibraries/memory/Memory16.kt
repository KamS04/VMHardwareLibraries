package ca.kam.vmhardwarelibraries.memory

interface Memory16 {
    fun getUByte(address: UShort): UShort

    fun setUByte(address: UShort, value: UShort): Boolean

    operator fun get(address: UShort): UShort = getUByte(address)

    operator fun set(address: UShort, value: UShort) = setUByte(address, value)
}