package day2.ads.java.Q3;

public class Program {
	
	public static void main(String[]args) {
//		Queue queue = new QueueArrayImp(4);
		
		Queue queue = new CircularQueue(5);
		
//		queue.peek();
		queue.add(12);
		queue.add(34);
		queue.add(24);
		queue.add(78);
		queue.add(65);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.peek());
			queue.remove();
		}
		
	}

}
