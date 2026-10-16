package org.sortedll;

public class DoublyLinkList {
	Node head;
	public static class Node{
		int data;
		Node previous;
		Node next;
		
		Node(int data){
			this.data = data;
			previous = null;
			next = null;
		}
	}
	
	public DoublyLinkList(){
		this.head = null;
	}
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		if(head.data >= data) {
			newNode.next = head;
			head.previous= newNode;
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			if(temp.next.data > data) {
				System.out.println("break called ");
				break;
			}
			temp = temp.next;
		}
		
		
		newNode.next = temp.next ;
		temp.next = newNode;
		newNode.previous = temp;
		
		
//		if(temp.next == null) {
//			temp.next =newNode;
//			newNode.previous = temp;
//			return;
//		}
//		newNode.next = temp;
//		newNode.previous = temp.previous;
//		temp.previous.next = newNode;
//		temp.previous= newNode;
		
	}
	
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}

}
