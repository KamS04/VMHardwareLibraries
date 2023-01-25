package ca.kam.vmhardwarelibraries

import ca.kam.vmhardwarelibraries.cpu.RequiredRegisters

interface RegistersFile {
    val registerNames: List<String>
    val requiredRegisters: RequiredRegisters
}
