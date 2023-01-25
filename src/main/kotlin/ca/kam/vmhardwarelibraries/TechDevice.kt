package ca.kam.vmhardwarelibraries

import ca.kam.vmhardwarelibraries.memory.MemoryDevice

class DeviceAsks(
    val name: UByte,
    val codeSpaceRequest: UShort,
    val commBufferRequest: UShort,
    val interrupts: Array<UShort>
)

interface TechDevice {
    // Used later
    val isForked: Boolean
    // Device Specifies itself
    fun deviceInfo(): DeviceAsks
    // Device MUST save the current memory device,
    // access to said memory device will never be given again
    fun lockBuffer(memory: MemoryDevice)
    // GetCodeArray
    @OptIn(ExperimentalUnsignedTypes::class)
    fun getCode(): UByteArray
    // Perform actions
    fun signal()
}
