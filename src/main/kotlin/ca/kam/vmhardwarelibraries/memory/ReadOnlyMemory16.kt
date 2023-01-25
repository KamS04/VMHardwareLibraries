package ca.kam.vmhardwarelibraries.memory

abstract class ReadOnlyMemory16: Memory16 {
    override fun setUByte(address: UShort, value: UShort): Boolean {
        // TODO LOG Error
        return false
    }
}
