package eg.edu.alexu.csd.datastructure.queue.cs22_cs29_cs79;


public class QueueL implements IQueue,ILinkedBased {

		class Node {
			
			Object value;
			Node next;
			
			Node(Object data){
				value = data;
				next = null;
			}
			
			Node (){
				value = null;
				next = null;
			}
			}

		Node head;
		private Node tail;
		
		private int size = 0;
		
		public void enqueue(Object item) {
			Node node = new Node(item);
			if (size == 0) {
				head = node;
				tail = node;
			}
			else {
			tail.next = node ;
			tail = node;
			}
			size++;
			return;
		}
		
		public Object dequeue() {
			if (size == 0) {
				throw new NullPointerException ("Empty queue");
			}
			else {
				Object o = head.value;
				head = head.next ;
				size--;
				return o;
			}
		}
		
		public boolean isEmpty() {
			if (size == 0)
				return true;
			else return false;
		}
		
		public int size() {
			return size;
		}

	}

