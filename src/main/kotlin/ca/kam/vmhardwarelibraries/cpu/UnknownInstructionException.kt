package ca.kam.vmhardwarelibraries.cpu

class UnknownInstructionException(instruction: String): Exception("Unknown instruction $instruction")