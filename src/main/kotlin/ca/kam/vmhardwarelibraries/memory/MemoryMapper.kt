package ca.kam.vmhardwarelibraries.memory

interface MemoryMapper: MemoryDevice {
    fun map(device: MemoryDevice, start: UShort, size: UShort, remap: Boolean = true)
    fun findDevice(address: UShort): Device?
    fun findDevice(name: String): Device?
}
