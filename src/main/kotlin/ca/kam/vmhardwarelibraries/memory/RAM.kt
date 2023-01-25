package ca.kam.vmhardwarelibraries.memory

@OptIn(ExperimentalUnsignedTypes::class)
open class RAM(
    val sizeInBytes: Int,
    override val name: String = "Ram"
) : MemoryDevice {
    val memory = UByteArray(sizeInBytes)

    override val bit8 = object: Memory8 {
        override fun getUByte(address: UShort): UByte = memory[address.toInt()]
        override fun setUByte(address: UShort, value: UByte): Boolean {
            memory[address.toInt()] = value
            return true
        }
    }

    override val bit16 = object: Memory16 {
        override fun getUByte(address: UShort): UShort {
            val iAddress = address.toInt()
            val high = memory[iAddress].toUInt() shl 8
            val low = memory[iAddress+1].toUInt()
            return (high or low).toUShort()
        }

        override fun setUByte(address: UShort, value: UShort): Boolean {
            val iAddress = address.toInt()
            memory[iAddress] = ((value and 0xff00u).toUInt() shr 8).toUByte()
            memory[iAddress+1] = (value and 0xffu).toUByte()
            return true
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