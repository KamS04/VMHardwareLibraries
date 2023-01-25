package ca.kam.vmhardwarelibraries.memory

interface ReadOnlyMemoryDevice: MemoryDevice {
    override val bit8: ReadOnlyMemory8
    override val bit16: ReadOnlyMemory16
}
