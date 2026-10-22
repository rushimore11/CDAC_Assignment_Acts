package ADS.Q3;

public class Main {
    public static void main(String[] args) {
      
        Deque dq = new Deque(5);

        dq.addEnd(10);     
        dq.addEnd(20);     
        dq.addFront(5); 
        dq.addFront(1);  
        dq.addEnd(30);   

        dq.display();

        dq.deleteFront();
        dq.deleteEnd();   

        dq.display();
        
        dq.addFront(99);  
        dq.display();
    }
}
