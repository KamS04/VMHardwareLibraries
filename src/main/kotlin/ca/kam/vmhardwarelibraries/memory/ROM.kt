package ca.kam.vmhardwarelibraries.memory

@OptIn(ExperimentalUnsignedTypes::class)
class ROM(
    val sizeInBytes: Int,
    override val name: String = "ROM"
): ReadOnlyMemoryDevice {
    val memory = UByteArray(sizeInBytes)

    override val bit8 = object: ReadOnlyMemory8() {
        override fun getUByte(address: UShort): UByte = memory[address.toInt()]
    }

    override val bit16 = object: ReadOnlyMemory16() {
        override fun getUByte(address: UShort): UShort {
            val iAddress = address.toInt()
            val high = memory[iAddress].toUInt() shl 8
            val low = memory[iAddress+1].toUInt()
            return (high or low).toUShort()
        }
    }

    override fun load(data: UByteArray, startAddress: UShort) {
        val iStartAddress = startAddress.toInt()
        data.forEachIndexed { index, uByte ->
            memory[iStartAddress + index] = uByte
        }
    }

    override fun slice(fAddress: UShort, tAddress: UShort): List<UByte> = memory.slice(
        fAddress.toInt() until tAddress.toInt()
    )
}
