package day2.ads.java.Q3;

public class QueueArrayImp implements Queue {
	int front;
	int rear;
	int SIZE;
	int[]queue;
	
	public QueueArrayImp(int capacity) {
		SIZE = capacity;
		rear = -1;
		front=-1;
		queue = new int[SIZE];
	}

	@Override
	public void add(int element) {
		if(isFull()) {
			resize();
		}
		if(rear == -1 && front == -1) {
			rear = front = 0;
			queue[rear]= element;
			return;
		}
		rear++;
		queue[rear] = element;

	}

	@Override
	public int remove() {
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		}
		int temp = queue[front];
		front++;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return front == -1 && rear == -1 || front>rear;
	}

	@Override
	public int peek() {
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		}
		
		return queue[front];
	}

	@Override
	public boolean isContains(int element) {
		for(int i=front;i<rear;i++) {
			if(queue[i] == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isFull() {
		
		return rear == SIZE-1;
	}
	
	private void resize(){
		SIZE = SIZE * 2;
		int[]newQueue = new int[SIZE];
		for(int i=0;i<queue.length;i++) {
			newQueue[i] = queue[i];
		}
		
		queue = newQueue;
		
	}
}
