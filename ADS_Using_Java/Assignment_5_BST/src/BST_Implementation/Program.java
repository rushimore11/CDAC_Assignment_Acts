package BST_Implementation;

import BST_Implementation.BinarySearchTree.Node;

public class Program {
	public static void main(String[]agrs) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(60);
		bst.addNode(10);
		bst.addNode(5);
		System.out.print("Binary Search Tree is = " );
		bst.printTree() ;
		
		System.out.println("Smallest Element in BST = " + bst.smallestElement());
		
		System.out.println("Largest Element in BST = " + bst.largestElement());
		
		System.out.println("Delete the node from BST= " + bst.deleteNode(bst.root, 10));
		
	}

}
