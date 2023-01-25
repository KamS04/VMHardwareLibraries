package ca.kam.vmhardwarelibraries.memory

@OptIn(ExperimentalUnsignedTypes::class)
interface MemoryDevice {
    val name: String
    val bit8: Memory8
    val bit16: Memory16
    fun load(data: UByteArray, startAddress: UShort = 0u)
    fun slice(fAddress: UShort, tAddress: UShort): List<UByte>
}
