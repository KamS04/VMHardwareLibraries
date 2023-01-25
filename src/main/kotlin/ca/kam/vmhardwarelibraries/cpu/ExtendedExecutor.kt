package ca.kam.vmhardwarelibraries.cpu

interface ExtendedExecutor {
    fun extend(cpu: CPUInterface, opcode: UByte): Boolean
}
