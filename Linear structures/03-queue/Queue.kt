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

    //getting size
    private fun size(): Int {
        return count
    }

    fun isEmpty(): Boolean {
        return size() == 0
    }

    //pushing
    fun push(value: String) {
        if (size() == q.size) {
            end = q.size
            resize(2 * q.size)
        }
        if (isEmpty())
            start = end
        q[end] = value
        end = (end + 1) % q.size
        count++
    }

    //poping the first value of Queue
    fun pop(): String {
        assert(start >= 0)
        val item = q[start]
        count--
        q[start] = null
        start = (start + 1) % q.size
        if (count == q.size / 4) {
            println("resize")
            resize(q.size / 2)
            end = q.size / 2
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
        q = new_array.requireNoNulls()
    }

    // print whole array or Queue
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

