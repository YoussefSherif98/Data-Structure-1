package eg.edu.alexu.csd.datastructure.queue.cs22_cs29_cs79;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	@Test
	void test() {
		
		QueueA q = new QueueA(5);
		
		assertEquals(true,q.isEmpty());
		assertEquals(0,q.size());
		
		q.enqueue(5);
		q.enqueue(10);
		q.enqueue(3);
		
		assertEquals(5,q.dequeue());
		assertEquals(10,q.dequeue());
		
		q.enqueue(2);
		q.enqueue(11);
		q.enqueue(25);
		q.enqueue(0);
		
		assertEquals(false,q.isEmpty());
		assertEquals(5,q.size());
		
		assertEquals(3,q.dequeue());
		assertEquals(2,q.dequeue());
		assertEquals(11,q.dequeue());
		assertEquals(25,q.dequeue());
		assertEquals(0,q.dequeue());
		
		assertEquals(true,q.isEmpty());
		assertEquals(0,q.size());
	}

}
