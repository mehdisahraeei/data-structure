import java.util.Stack;
 
public class StackClassJava {
 
 
    // pushing
    public void push(Stack<Integer> stack, int j){
        System.out.println("Inserting " + j +  " into Stack.");
        stack.push(j);
    }
 
 
    // removing or poping the last value
    public Integer pop(Stack<Integer> stack){
        if(stack.empty()==false){
            System.out.println("Popping Element from stack");
            return stack.pop();
        }else {
            System.out.println("Stack is empty");
            return null;
        }
    }
 
 
    // peek returns the last value but doesn't pop the value
    public Integer peek(Stack<Integer> stack){
        if(stack.empty()==false){
            System.out.println("peeking Element from stack");
            return stack.peek();
        }else {
            System.out.println("Stack is empty");
            return null;
        }
    }
 
 
 
    public Integer getSize(Stack<Integer> stack){
        System.out.println("Stack Size: " +  stack.size());
        return stack.size();
    }
 
 
    public Boolean isEmpty(Stack<Integer> stack){
        return stack.isEmpty();
    }
 
 
    public void search(Stack<Integer> stack, int element){
        System.out.println("Searching element " + element + " in Stack");
        int index = stack.search(element);
        if(index==-1){
            System.out.println(element + " not found in Stack");
        }else{
            System.out.println(element + " found in Stack at position: " + index);
        }
    }
 
 
 
    public void displayStack(Stack<Integer> stack){
        System.out.println(stack);
    }
 
 
 
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
 
        StackClassJava scj = new StackClassJava();
 
        //push operation
        scj.push(stack, 1);
        scj.push(stack, 2);
        scj.push(stack, 3);
 
        //pop operation
        System.out.println("Popped Element: " + scj.pop(stack));
        System.out.println("Popped Element: " + scj.pop(stack));
        
        
        scj.displayStack(stack);
        scj.push(stack,6);
        
        
        System.out.println("Peeking Element: " + scj.peek(stack));
        scj.displayStack(stack);
        
        
        //check if stack is empty
        System.out.println("Is Stack Empty: " + scj.isEmpty(stack));
        System.out.println("Stack Size: " + scj.getSize(stack));
 
 
        //search element in stack
        scj.search(stack, 5);
        scj.search(stack, 1);
    }
}
