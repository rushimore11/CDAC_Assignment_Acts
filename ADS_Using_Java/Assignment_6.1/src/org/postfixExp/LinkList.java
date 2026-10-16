package org.postfixExp;

public class LinkList {
	Node head;
	public static class Node{
		String data;
		Node next;
		
		public Node(String ch) {
			this.data = ch;
			next = null;
		}
	}
	
	public void addFront(String ch) {
		Node newNode = new Node(ch);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public String deleteFront() {
		if(head == null) {
			throw new NullPointerException("empty LinkList");
		}
		
		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp.data;
	}
	
	public String firstElement() {
		return head.data;
	}
	
	
}
