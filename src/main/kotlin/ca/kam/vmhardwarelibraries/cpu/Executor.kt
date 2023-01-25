package ca.kam.vmhardwarelibraries.cpu

interface Executor {
    fun execute(cpu: CPUInterface, opcode: UByte): Boolean
}