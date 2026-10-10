package day2.ads.java.Q3;

public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(String string) {
		super("Queue is Empty");
	}
}
