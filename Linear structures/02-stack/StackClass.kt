import java.util.*

class StackClassJava {

    // pushing
    fun push(stack: Stack<Int>, j: Int) {
        println("Inserting $j into Stack.")
        stack.push(j)
    }

    // removing or poping the last value
    fun pop(stack: Stack<Int>): Int? {
        return if (stack.empty() == false) {
            println("Popping Element from stack")
            stack.pop()
        } else {
            println("Stack is empty")
            null
        }
    }

    // peek returns the last value but doesn't pop the value
    fun peek(stack: Stack<Int>): Int? {
        return if (stack.empty() == false) {
            println("peeking Element from stack")
            stack.peek()
        } else {
            println("Stack is empty")
            null
        }
    }

    fun getSize(stack: Stack<Int>): Int {
        println("Stack Size: " + stack.size)
        return stack.size
    }

    fun isEmpty(stack: Stack<Int>): Boolean {
        return stack.isEmpty()
    }

    fun search(stack: Stack<Int>, element: Int) {
        println("Searching element $element in Stack")
        val index = stack.search(element)
        if (index == -1) {
            println("$element not found in Stack")
        } else {
            println("$element found in Stack at position: $index")
        }
    }

    fun displayStack(stack: Stack<Int>) {
        println(stack)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stack = Stack<Int>()
            val scj = StackClassJava()

            //push operation
            scj.push(stack, 1)
            scj.push(stack, 2)
            scj.push(stack, 3)

            //pop operation
            println("Popped Element: " + scj.pop(stack))
            println("Popped Element: " + scj.pop(stack))

            scj.displayStack(stack)
            scj.push(stack, 6)

            println("Peeking Element: " + scj.peek(stack))
            scj.displayStack(stack)

            //check if stack is empty
            println("Is Stack Empty: " + scj.isEmpty(stack))
            println("Stack Size: " + scj.getSize(stack))

            //search element in stack
            scj.search(stack, 5)
            scj.search(stack, 1)
        }
    }
}

