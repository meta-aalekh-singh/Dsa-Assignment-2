import java.util.*;
public class Queue { 
    private static int front, rear, capacity; 
    private static int queue[]; 
   
    Queue(int size) { 
        front = rear = 0; 
        capacity = size; 
        queue = new int[capacity]; 
    } 
   
    // insert an element into the queue
     void queueEnqueue(int item)  { 
        // check if the queue is full
        if (capacity == rear) { 
            System.out.printf("Queue is full"); 
            return; 
        } 
   
        else { 
            queue[rear] = item; 
            rear++; 
        } 
        return; 
    } 
   
    //remove an element from the queue
     void queueDequeue()  { 
        // check if queue is empty 
        if (front == rear) { 
            System.out.printf("\nQueue is empty\n"); 
            return; 
        } else { 
            for (int i = 0; i < rear - 1; i++) { 
                 queue[i] = queue[i + 1]; 
            } 
            if (rear < capacity){ 
                 queue[rear] = 0; 
            }
            rear--; 
        } 
        return; 
    } 
   
     void queueDisplay() 
    { 
        int i; 
        if (front == rear) { 
            System.out.printf("Queue is Empty\n"); 
            return; 
        } 
        for (i = front; i < rear; i++) { 
            System.out.printf(" %d = ", queue[i]); 
        } 
        return; 
    } 
   
     void queueFront() 
    { 
        if (front == rear) { 
            System.out.printf("Queue is Empty\n"); 
            return; 
        } 
        System.out.printf("\nFront Element of the queue: %d", queue[front]); 
        return; 
    } 
} 
 
 class Main {
    public static void main(String[] args) {
    	int i,value,numOfElement;
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of element for queue : ");
        numOfElement=sc.nextInt();
        Queue q = new Queue(numOfElement); 
        for(i=0;i<numOfElement;i++){
        	System.out.println("Enter "+ (i+1)+ " element of queue : ");
        	value=sc.nextInt();
        	q.queueEnqueue(value);
        }
        System.out.println("Queue after Enqueue Operation:");
        q.queueDisplay(); 
        System.out.println("Front element of queue : ");
        q.queueFront(); 
        System.out.println("If we add another value to queue : ");
        q.queueEnqueue(90);    
        q.queueDisplay(); 
        q.queueDequeue(); 
        q.queueDequeue(); 
        System.out.printf("\nQueue after two dequeue operations:");  
        q.queueDisplay(); 
        q.queueFront(); 
    } 
}