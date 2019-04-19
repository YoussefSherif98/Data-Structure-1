package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs79;

public class MyLinkedList_Single implements ILinkedList {

	
	Node_S head=null;
	
	public void add(int index, Object element) {

		Node_S node = new Node_S(element);
		if(index==0)
		{
			node.next=head;
			head=node;
		}
		else
		{
			Node_S n=head;
			for(int i=1;i<index;i++)
			{
				if(n==null)
				{
					System.out.println("Index out of bounds");
					return;
				}
				n=n.next;
			}
			node.next=n.next;
			n.next=node;
		}
		return;
	}

	
	public void add(Object element) {
		Node_S node=new Node_S(element);
		if(head==null)
			head=node;
			
		else
		{
			Node_S n=head;
			while(n.next!=null)
				n=n.next;
			
			n.next=node;
		}
			
		
	}

	
	public void display()
	{
		Node_S n=head;
		while(n!=null) 
		{
			System.out.print(n.value+" ");
			n=n.next;
		}
		System.out.println();
			
	}
	
	public Object get(int index) {
		
		Node_S n=head;
		
		for(int i=0;i<index;i++)
		{
			if(n==null)
				return null;
			n=n.next;
		}
		return n.value;
		
	}
	
	public void set(int index, Object element) {
		
        Node_S n=head;
		
		for(int i=0;i<index;i++)
		{
			if(n==null)
				return;
			n=n.next;
		}
		n.value=element;
		return;
		
	}

	public void clear() {
		
		head=null;
		return;
		
	}

	public boolean isEmpty() {
		
		if(head==null)
			return true;
		return false;
	}

	public void remove(int index) {
		
		if(index==0)
		{
			head=head.next;
			return;
		}
		
		Node_S n=head;
		
		for(int i=1;i<index;i++)
		{
			if(n==null)
				return;
			n=n.next;
		}
		
		if(n.next==null)
		{
			n=null;
			return;
		}
		
		n.next=n.next.next;
		return;
	}

	public int size() {
		
		int count=0;
		Node_S n=head;
		while(n!=null)
		{
			count++;
			n=n.next;
		}
		return count;
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		Node_S n=head;
		for(int i=0;i<fromIndex;i++)
		{
			if(n==null)
				return null;
			n=n.next;
		}
		
		MyLinkedList_Single newList= new MyLinkedList_Single();
		
		Node_S newHead = new Node_S(n.value);
		
		newList.head=newHead;
		
		Node_S n2=newHead;
		for(int i=0;i<toIndex-fromIndex;i++)
		{
			n=n.next;
			Node_S newNode = new Node_S(n.value);
			n2.next=newNode;
			n2=n2.next;
			
		}
		return newList;
	}

	public boolean contains(Object o) {
		Node_S n=head;
		while(n!=null)
		{
			if(n.value==o)
				return true;
			n=n.next;
		}
		return false;
	}

}
