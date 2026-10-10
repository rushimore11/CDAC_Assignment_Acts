package day2.ads.java.Q3;

public class QueueOutOfBoundsException extends RuntimeException {
	public QueueOutOfBoundsException() {
		super("queue is full");
	}
}
