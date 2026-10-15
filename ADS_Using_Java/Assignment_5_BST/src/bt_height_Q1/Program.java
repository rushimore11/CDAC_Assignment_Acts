package bt_height_Q1;

public class Program {
	public static void main(String[]main) {
		int[]arr = {1,2,4,5,6,3,7,8,9,10};
		BinaryTree bt = new BinaryTree(arr);

		
		System.out.println("height of the tree...");
		System.out.println(bt.heightOfTree(bt.root));
	
		
	}

}
