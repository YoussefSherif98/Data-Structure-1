package eg.edu.alexu.csd.datastructure.queue.cs22_cs29_cs79;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {

	@Test
	void test() {

		QueueL q = new QueueL();
		
		
		assertEquals(true,q.isEmpty());
		assertEquals(0,q.size());
		
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		
		assertEquals('a',q.dequeue());
		assertEquals('b',q.dequeue());
		
		q.enqueue('d');
		q.enqueue('e');
		q.enqueue('f');
		q.enqueue('g');
		
		assertEquals(false,q.isEmpty());
		assertEquals(5,q.size());
		
		assertEquals('c',q.dequeue());
		assertEquals('d',q.dequeue());
		assertEquals('e',q.dequeue());
		assertEquals('f',q.dequeue());
		assertEquals('g',q.dequeue());
		
		assertEquals(true,q.isEmpty());
		assertEquals(0,q.size());
	}

}
