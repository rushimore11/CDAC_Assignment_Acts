package day2.ads.java.Q4;

public interface Queue <T>{
	void add(T element);
	T remove();
	boolean isEmpty();
	T peek();
	boolean isContains(T element);
	boolean isFull();
}
