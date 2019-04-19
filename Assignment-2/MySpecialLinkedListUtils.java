package Deliverable;

public class MySpecialLinkedListUtils {
	
	LinkedListNode head;
	
	public static int getLength(LinkedListNode head)
	{
		int counter=0;
		LinkedListNode node=head;
		while(node!=null)
		{
			counter++;
			node=node.next;
		}
		return counter;
	}
	
	public static double[] summary(LinkedListNode head) {
		double[] summ= {0,0,0,0,0};
		summ[3]=head.value;
		summ[4]=head.value;
		
		LinkedListNode node=head;
		
		int num=getLength(head);
		
		if(node==null)
			return summ;
		else
		{
			while(node!=null)
			{
				summ[0]+=node.value;
				if(node.value>summ[3])
					summ[3]=node.value;
				if(node.value<summ[4])
					summ[4]=node.value;
				
				node=node.next;
			}
			
			node=head;
			
			if(num%2==0)
			{
				for(int i=0;i<(num/2-1);i++)
					node=node.next;
				
				summ[2]=((double)node.value+(double)node.next.value)/2.0;
					
			}
			else
			{
				for(int i=0;i<(num/2);i++)
					node=node.next;
				
				summ[2]=node.value;
			}
			
		}
		summ[1]=summ[0]/(double)num;
		
		return summ;
		 
	 }

	public static LinkedListNode reverse(LinkedListNode head)
	{
		LinkedListNode n1=head,n2=n1,n3=head.next;
		n1.next=null;
		while(n3!=null)
		{
			n1=n3;
			n3=n3.next;
			n1.next=n2;
			n2=n1;
		}
		return n2;
		
	}

	public static LinkedListNode evenIndexedElements (LinkedListNode head)

	{
		LinkedListNode node=head;
		
		while(node!=null)
		{
			if(node.next!=null) {
			    node.next=node.next.next;
			    node=node.next;
			}
			else
			{
				node=null;
			}
		}
		return head;
	}

	public static LinkedListNode removeCentralNode(LinkedListNode head)
	{
		int num=getLength(head);
		
		LinkedListNode node=head;
		if(num==0 || num==1)
			return null;
		else if(num==2)
		{
			head=head.next;
		}
		
		for(int i=2;i<num/2.0;i++)
		{
			node=node.next;
		}
		node.next=node.next.next;
		
		return head;
	}

	public static LinkedListNode insertionSort(LinkedListNode head) {
		LinkedListNode head2=null , current1=head, current2=null,next=null;
		while(current1!=null)
		{
			next=current1.next;
			
			if(head2==null || current1.value<=head2.value)
			{
				current1.next=head2;
				head2=current1;
			}
			
			else
			{
				current2=head2;
				while(current2.next!=null && current1.value >= current2.next.value )
				{
					current2=current2.next;
				}
				current1.next=current2.next;
				current2.next=current1;
			}
			
			current1=next;
		}
		
		return head2;
	}

    public static LinkedListNode sorting(LinkedListNode left, LinkedListNode right)
	{
		if(left==null)
			return right;
		if(right==null)
			return left;
		
		LinkedListNode result=null;
		
		if(left.value<=right.value)
		{
			result=left;
			result.next=sorting(left.next , right);
		}
		else
		{
			result=right;
			result.next=sorting(left , right.next);
		}
		
		return result;
		
	}
    
    public static LinkedListNode mergeSort(LinkedListNode head)
    {
    	int num=getLength(head);
    	LinkedListNode mid=head,midnext;
    	LinkedListNode left,right;
    	
    	if (head==null || head.next==null)
    		return head;
    	
    	for(int i=1;i<(double)num/2.0;i++)
    		mid=mid.next;
    	
    	midnext=mid.next;
    	mid.next=null;
    	
    	left= mergeSort(head);
    	right= mergeSort(midnext);
    	
    	return sorting(left,right);
    	
    }
	
    public static boolean palindrome(LinkedListNode head)
	{
		int num=getLength(head);
		LinkedListNode node1=head , node2 , node=head ,n=null;
		
		if (num==1|| num==0)
			return true;
		for(int i=0;i<num/2;i++)
		{
			while(node.next!=null)
			{
				if(node.next.next==null)
					n=node;
				node=node.next;
			}
			node2=node;
			if(node1.value!=node2.value)
				return false;
			node1=node1.next;
			n.next=null;
			node=node1;
		}
		return true;
	}
}
