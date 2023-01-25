package ca.kam.vmhardwarelibraries

import ca.kam.vmhardwarelibraries.cpu.CPUInterface
import ca.kam.vmhardwarelibraries.memory.MemoryDevice

interface Cartridge {
    fun loadInto(memory: MemoryDevice, size: Int)

    val interruptVectorAddress: UShort

    fun initializeGraphics(cpu: CPUInterface)

    val isForkedGraphics: Boolean

    fun startCPU(cpu: CPUInterface)

    fun exitGraphics()
}