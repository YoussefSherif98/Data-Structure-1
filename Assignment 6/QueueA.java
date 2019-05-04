package eg.edu.alexu.csd.datastructure.queue.cs22_cs29_cs79;

public class QueueA implements IQueue,IArrayBased {
	
    Object[]queue;
	
    QueueA(int number){
      queue=new Object[number];
    }
    
    int r=-1;
    
    public void enqueue(Object item){
        r++;
        if(r==queue.length)
            throw new RuntimeException ("The queue is full");
        queue[r]=item;
    }
    
    public Object dequeue(){
        if(r==-1)
            throw new RuntimeException ("The queue is empty");
        Object temp=queue[0];
        for(int i=0;i<r;i++){
            queue[i]=queue[i+1];
        }
        r--;
        return temp;
    }
    
    public boolean isEmpty(){
     return (r<0);
    }
    
    public int size(){
        return (r+1);
    }


}
