package ca.kam.vmhardwarelibraries.memory

data class Device(
    val device: MemoryDevice,
    val start: UShort,
    val end: UShort,
    val size: UShort,
    val remap: Boolean
)
