package day2.ads.java.Q2;

public class FixedSizeStack implements Stack {

	int[]stack;
	int SIZE;
	int top;
	FixedSizeStack(int intialCapacity){
		this.SIZE = intialCapacity;
		top = -1;
		stack = new int[SIZE];
	}
	
	@Override
	public void push(int element) {
		if(isFull()) {
			resize();
		}
		top++;
		stack[top] = element;

	}

	@Override
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int temp = stack[top];
		top--;
		return temp;
	}

	@Override
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
			return stack[top];
	}

	@Override
	public boolean isEmpty() {
		
		return top == -1;
	}

	@Override
	public boolean isFull() {
		
		return top == SIZE-1;
	}
	
	private void resize(){
		SIZE = SIZE * 2;
		int[]newStack = new int[SIZE];
		for(int i=0;i<stack.length;i++) {
			newStack[i] = stack[i];
		}
		
		stack = newStack;
		
	}

		

}


