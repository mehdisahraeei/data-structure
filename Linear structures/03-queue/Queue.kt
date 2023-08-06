class Queue {
    private var start = -1
    private var q = arrayOf<String>()
    private var end = 0
    private var count = 0

    init {
        start = -1
        end = 0
        q = arrayOf<String>()
    }

    // Getting the size of the queue
    private fun size(): Int {
        return count
    }

    // Check if the queue is empty
    fun isEmpty(): Boolean {
        return size() == 0
    }

    // Pushing a value to the queue
    fun push(value: String) {
        if (size() == q.size) {   // If the array is full, resize it to accommodate more elements
            end = q.size
            resize(2 * q.size)    // Double the size of the array
        }
        if (isEmpty())
            start = end          // Set the start to the current end if the queue was empty
        q[end] = value
        end = (end + 1) % q.size // Update the end index with wrapping around the array
        count++
    }

    // Popping the first value from the queue
    fun pop(): String {
        assert(start >= 0)        // Ensure that the queue is not empty
        val item = q[start]
        count--
        q[start] = null
        start = (start + 1) % q.size // Move the start index to the next element with wrapping
        if (count == q.size / 4) {
            println("resize")
            resize(q.size / 2)   // Shrink the array if the number of elements is 1/4 of its capacity
            end = q.size / 2     // Reset the end index after resizing
        }
        return item
    }

    fun resize(new_size: Int) {
        val new_array = arrayOfNulls<String>(new_size)
        val old_size = q.size
        var i = start
        val limit = if (start < end) end else old_size
        for (i in start until limit) {
            new_array[i - start] = q[i]
        }
        if (end < start) {
            var j = 0
            while (j < end) {
                new_array[i] = q[j]
                i++
                j++
            }
        }
        start = 0
        q = new_array.requireNoNulls()  // Replace the old array with the new resized array
    }

    // Print the whole queue
    fun printQueue() {
        q.forEach { s -> println(s) }
    }
}

fun main() {
    val queue = Queue()

    queue.push("i")
    queue.push("r")
    queue.push("a")
    queue.push("n")

    println("------------------------------")
    queue.printQueue()

    queue.pop()

    queue.printQueue()
}
