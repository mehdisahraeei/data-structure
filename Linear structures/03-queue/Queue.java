public class Queue {
    private int start;        // Index of the first element in the queue
    private String[] q;       // Array to store the elements of the queue
    private int end;          // Index where the next element should be added
    private int count = 0;    // Number of elements currently in the queue

    public Queue() {
        start = -1;          // Initialize start to an invalid index
        end = 0;             // Initialize end to the beginning of the array
        q = new String[1];   // Initialize the array with size 1
    }

    // Getting the size of the queue
    private int size() {
        return count;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Pushing a value to the queue
    public void push(String value) {
        if (size() == q.length) {   // If the array is full, resize it to accommodate more elements
            end = q.length;
            resize(2 * q.length);   // Double the size of the array
        }
        if (isEmpty())
            start = end;            // Set the start to the current end if the queue was empty
        q[end] = value;
        end = (end + 1) % q.length; // Update the end index with wrapping around the array
        count++;
    }

    // Popping the first value from the queue
    public String pop() {
        assert (start >= 0);        // Ensure that the queue is not empty
        String item = q[start];
        count--;
        q[start] = null;
        start = (start + 1) % q.length; // Move the start index to the next element with wrapping
        if (count == q.length / 4) {
            System.out.println("resize");
            resize(q.length / 2);  // Shrink the array if the number of elements is 1/4 of its capacity
            end = q.length / 2;    // Reset the end index after resizing
        }
        return item;
    }

    // Resizing the queue
    public void resize(int new_size) {
        String[] new_array = new String[new_size];
        int old_size = q.length;
        int i = start;
        int limit = (start < end) ? end : old_size;
        for (i = start; i < limit; i++) {
            new_array[i - start] = q[i];
        }
        if (end < start) {
            for (int j = 0; j < end; j++) {
                new_array[i] = q[j];
                i++;
            }
        }
        start = 0;
        q = new_array;           // Replace the old array with the new resized array
    }

    // Print the whole queue
    public void printQueue() {
        for (String s : q) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Queue object = new Queue();

        object.push("i");
        object.push("r");
        object.push("a");
        object.push("n");

        System.out.println("------------------------------");

        object.printQueue();

        object.pop();

        object.printQueue();

        //System.out.println("size: " + obj1.size());
    }
}
