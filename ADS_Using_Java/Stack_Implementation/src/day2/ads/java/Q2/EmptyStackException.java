package day2.ads.java.Q2;

public class EmptyStackException extends RuntimeException {
	public EmptyStackException(){
		super("Stack is empty");
	}
}
