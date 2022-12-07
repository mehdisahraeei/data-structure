

public class Queue {
 


	private int start;
	private String [] q;
	private int end;
	private int count = 0;
	

	
	public Queue(){
		start = -1;
		end = 0;
		q = new String[1];
	}
	
	
	//getting size
	private int size(){
		return count;
	}

	
	
	public boolean isEmpty(){
		return size() == 0;
	}

	
	//pushing
	public void push(String value){
		if (size() == q.length){
			end = q.length;
			resize(2 * q.length);
		}
		if (isEmpty())
		  start = end;
		q[end] = value;
		end = (end + 1) % q.length;
		count ++;
	}
	

	//poping the first value of Queue
	public String pop(){
		assert (start >=0);
		String item = q[start];
		count--;
		q[start] = null;
		start = (start + 1) % q.length;
		if (count == q.length / 4){
			System.out.println("resize");
			resize(q.length / 2);
			end = q.length /2;
		}
		return item;
	}
	
	
	
	public void resize(int new_size) {
		String [] new_array = new String[new_size];
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
		q = new_array;
	}
	


        // print whole array or Queue
	public void printQueue() {
		for (String s: q) {
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
