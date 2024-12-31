package ca.kam.vmhardwarelibraries.cpu

import ca.kam.vmhardwarelibraries.memory.MemoryDevice

interface CPUInterface {
    //region Registers
    val Registers: RequiredRegisters
    fun registerIndex(register: String): UShort
    fun getRegister(register: String): UShort
    fun getRegister(registerIndex: UShort): UShort
    fun setRegister(register: String, value: UShort): Boolean
    fun setRegister(registerIndex: UShort, value: UShort): Boolean
    fun setRegister(register: String, value: UInt): Boolean
    val registers: MemoryDevice
    fun regIdxToName(rIdx: UShort): String
    //endregion

    //region attached devices
    val memMode: UByte
    var cMemSpace: UShort
    val memory: MemoryDevice
    fun getRealAddress(address: UShort): UShort
    fun moveMemoryBlock(from: UShort, to: UShort, length: UShort)

    fun quickMemMode(nMode: UByte) // use when not crossing memory device bounds
    fun setupMemMode(nMode: UByte) // use when crossing memory device bounds

    fun signal(id: UByte)
    //endregion

    fun debug()

    //region Fetch


    fun fetch(noIncrement: Boolean = false): UByte
    fun fetch16(noIncrement: Boolean = false): UShort
    fun fetchRegisterIndex(noIncrement: Boolean = false): UShort
    //endregion

    //region Subroutines
    fun push(value: UShort)
    fun pop(): UShort
    fun pushState()
    fun popState()
    fun handleInterrupt(value: UShort)
    fun exitInterruptHandler()
    fun jumpToAddress(address: UShort)
    //endregion
}