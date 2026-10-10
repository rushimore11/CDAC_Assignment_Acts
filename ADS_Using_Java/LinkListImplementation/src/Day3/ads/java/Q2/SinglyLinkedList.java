package Day3.ads.java.Q2;


import java.util.NoSuchElementException;

public class SinglyLinkedList <T>implements List<T> {
	
	
	//creation of node
	public static class Node<T>{
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	Node<T> head;
	Node<T> tail;
	
	//constructor of node
	public SinglyLinkedList() {
		System.out.println("Constructor Called");
		head = null;
		tail = null;
	}

	
	//methods for linkedlist
	
	
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public void addFront(T element) {
		System.out.println("creating node");
		Node<T> newNode = new Node<T>(element);
		if(isEmpty())
		{
			head = tail = newNode;
			return;
		}
		System.out.println("Added successfully");
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void addEnd(T element) {
		System.out.println("creating node");
		Node<T> newNode = new Node<T>(element);
		if(isEmpty())
		{
			head = tail= newNode;
			return;
		}
		System.out.println("Added successfully");
		System.out.println(element);
		tail.next = newNode;
		tail = newNode;
		
	}

	@Override
	public T deleteFront() {
		if(isEmpty())
		{
			throw new NoSuchElementException("NO Linkedlist");
		}
		Node<T> temp = head;
		head = head.next;
		temp.next = null;
		return temp.data;
	}

	@Override
	public T deleteEnd() {
		if(isEmpty())
		{
			throw new NoSuchElementException("NO Linkedlist");
		}
		Node<T> temp = head;
		while(temp.next != tail)
		{
			temp = temp.next;
		}
		temp.next = null;
		Node<T> temp1 = tail;
		tail = temp;
		return temp1.data;
	}

	@Override
	public void display() {
			System.out.println("in display");
			if(isEmpty())
			{
				System.out.println("LinkedList is empty");
				return;
			}
			Node<T> temp = head;
			while(temp != tail.next)
			{
				System.out.print(temp.data + "--->");
				temp = temp.next;
				
			}
			System.out.print("Null");
		
	}

}
