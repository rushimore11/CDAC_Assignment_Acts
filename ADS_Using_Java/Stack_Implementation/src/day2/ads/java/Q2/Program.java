package day2.ads.java.Q2;

public class Program {
	public static void main(String[]args) {
		Stack stack = new FixedSizeStack(5);
		stack.push(10);
		stack.push(12);
		stack.push(45);
		stack.push(67);
		stack.push(32);
		stack.push(101);
		stack.push(9800);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
		
		
		
	}
}
