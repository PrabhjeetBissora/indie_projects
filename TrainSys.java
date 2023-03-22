// implementation of train system

class StackException extends Exception { 
    public StackException(String str) {
        super(str);
    }
}

class Stack {
       
    class Node {
        int data;
        Node next;  
    }
    private Node top;
      
    public Stack()
    { 
        top = null;
    }
        
    public void push(int x) {
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }

    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public int pop() throws StackException
    {
        if(this.isEmpty()) 
            throw new StackException("\nIllegal to pop() an empty Stack\n");
        
        int x = top.data;
        top = top.next;
        return x;        
    }

    
    public boolean isEmpty(){
       return top == null;
    }


    public int size() {
        int c = 0;
        Node t = top;
        while(t != null) {
            ++c;
            t = t.next;
        }
        return c;        
    }
    
    public void display() {
        Node t = top;
        System.out.println("\nStack contents are:  ");
        
        while (t != null) {            
            System.out.print(t.data + " ");
            t = t.next;
        }       
        System.out.println("\n");
    }

}


public class TrainSys
{
    public static void main( String[] arg){
        Stack s = new Stack();
        System.out.println("Stack is created\n");
        
        // piece of code to test our exception mechanism
        try {
            s.pop();
        } catch (StackException e) {
            System.out.println("Exception thrown: " + e);
        }
        
        s.push(10); s.push(3); s.push(11); s.push(7);
        s.display();
        
        System.out.println("Stack size is " + s.size());
       
       /* int i = s.pop();
        System.out.println("Just popped " + i);
        s.display();
        */
    }
}


