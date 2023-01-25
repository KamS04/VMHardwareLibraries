package ca.kam.vmhardwarelibraries.memory

abstract class ReadOnlyMemory8: Memory8 {
    override fun setUByte(address: UShort, value: UByte): Boolean {
        // TODO LOG Error
        return false
    }
}