package org.postfixExp;

public class Stack {
	LinkList list ;
	Stack(){
		list = new LinkList();
	}
	
	public void push(String ch) {
		list.addFront(ch);
	}
	
	public String pop() {
		return list.deleteFront();
	}
	
	public String peek() {
		return list.firstElement();
	}
	
	public boolean isEmpty() {
		return list.firstElement() == null;
	}
	
	
	

}
