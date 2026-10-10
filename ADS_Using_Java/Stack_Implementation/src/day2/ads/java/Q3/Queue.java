package day2.ads.java.Q3;

public interface Queue {
	void add(int element);
	int remove();
	boolean isEmpty();
	int peek();
	boolean isContains(int element);
	boolean isFull();
}
