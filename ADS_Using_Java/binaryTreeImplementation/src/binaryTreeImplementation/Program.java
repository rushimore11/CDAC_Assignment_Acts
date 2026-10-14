package binaryTreeImplementation;

public class Program {
	public static void main(String[]main) {
		int[]arr = {1,2,4,5,6,3,7,8,9,10};
		BinaryTree bt = new BinaryTree(arr);
		
		System.out.println("inorder traversal........");
		bt.printInorder(bt.root);
		System.out.println();
		System.out.println("preorder trversal..........");
		bt.printPreorder(bt.root);
		System.out.println();
		System.out.println("postorder traversal.......");
		bt.printlnPostorder(bt.root);
		System.out.println();
		System.out.println("level order trveresal.........");
		System.out.println(bt.levelOrder(bt.root));
		
		System.out.println("number of nodes in tree........");
		System.out.println(bt.countNodes(bt.root));
		
		System.out.println("height of the tree...");
		System.out.println(bt.heightOfTree(bt.root));
		
		System.out.println("number of leaf nodes......");
		System.out.println(bt.countLeafNodes(bt.root));
		
		int value = 9;
		System.out.println("Nodes with value "+value);
		System.out.println(bt.countNodesWithValue(bt.root, value));
		
		
		
	}

}
