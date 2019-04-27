package eg.edu.alexu.csd.datastructure.stack.cs79;

public class Stack implements IStack {
	
	
	/**
	 * Node containing an element in the stack
	 * @author YOUSSEF
	 *
	 */
	static class Node {
		
		/**
		 * Value of the node
		 */
		Object value;
		
		
		/**
		 * Pointer to the node after this node on the stack
		 */
		Node next;
		
		/**
		 * Node constructor
		 * @param element to insert
		 */
		public Node(Object element)
		{
			this.value=element;
			
		}

	}
	
	/**
	 * Pointer to the node at the top of the stack
	 */
    private Node top=null ;
	
    /**
     * Variable saving the size of the stack, so that the size method operates in O(1)
     */
	public int n = 0;
	
	
	/** 
	 * Removes the element at the top of stack and returns that element. 
	 * 
	 * @return top of stack element, or through exception if empty */ 
	public Object pop() {
		
		if(n==0)
		{
			System.out.println("Empty Stack Exception");
			return null;
		}
		
		Object t=top.value;
		
		top=top.next;
		
		n--;
		
		return t;
	}

	
	/**
	 *  Get the element at the top of stack without removing it from stack. 
	 *  
	 * @return top of stack element, or through exception if empty
	 */

	public Object peek() {
		
		if(n==0)
		{
			System.out.println("Empty Stack Exception");
			return null;
		}
		
		return top.value;
	}

	
	/**
	 *  Pushes an item onto the top of this stack. 
	 *  
	 * @param element object to insert
	 */
	public void push(Object element) {

		Node newTop= new Node(element);
		
		newTop.next=top;
		
		top=newTop;
		
		n++;
	}

	
	/**
	 *  Tests if this stack is empty
	 *  
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {

		return (n<1);
	}

	
	/**
	 *  Returns the number of elements in the stack. 
	 *  
	 * @return number of elements in the stack
	 */
	public int size() {

		return n;
	}

	
	/**
	 * Displays the elements of the stack in a stack-like form
	 * 
	 */
	public void display()
	{
		Node n=top;
		while(n!=null)
		{
			System.out.println("| "+n.value+" |");
			n=n.next;
		}
		System.out.println("-----");
	}
}
