package ca.kam.vmhardwarelibraries.memory

abstract class MemoryCreators {
    abstract fun RAM(sizeInBytes: Int, name: String = "RAM"): MemoryDevice

    abstract fun ROM(sizeInBytes: Int, name: String = "ROM"): ReadOnlyMemoryDevice

    companion object {
        private var _current: MemoryCreators? = null

        var create: MemoryCreators
            get() = _current ?: throw Exception("WTF how u creating memory before making a creator?")
            set(value) {
                if (_current != null) {
                    throw Exception("WTF who the hell is trying to fuck up the creators?")
                }
                _current = value
            }
    }
}