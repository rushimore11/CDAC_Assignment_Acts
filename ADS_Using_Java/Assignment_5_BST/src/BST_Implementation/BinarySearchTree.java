package BST_Implementation;

public class BinarySearchTree {
	Node root;
	public class Node{
		int data;
		Node right;
		Node left;
		
		public Node(int data) {
			this.data = data;
			right = null;
			left = null;
		}
	}
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node curr = root;
		while(curr != null) {
			if(curr.data ==  data) {
//				Duplicates are not allowed
				return;
			}
			
			if(data < curr.data) {
				if(curr.left == null) {
					curr.left = newNode;
					return;
				}
				curr = curr.left;
			}else {
				if(curr.right == null) {
					curr.right = newNode;
					return;
				}
				curr = curr.right;
			}
		}
		
	}
	
	public void printTree() {
		print(root);
		System.out.println();
	}
	
	private static void print(Node parent) {
		if (parent == null) {
			return;
		}
		print (parent.left);
		System.out.print(parent.data + " ") ;
		print(parent.right);
	}
	
	public int smallestElement() {
		if(root == null) {
			throw new NullPointerException("Tree is empty..");
		}
		Node curr = root;
		while(curr.left != null) {
			curr = curr.left;
		}
		return curr.data;
	}
	
	public int largestElement() {
		if(root == null) {
			throw new NullPointerException("Tree is empty.......");
		}
		Node curr = root;
		while(curr.right != null) {
			curr = curr.right;
		}
		return curr.data;
	}
	
	public Node deleteNode(Node root, int key) {
		if(root == null) {
			throw new NullPointerException("Tree is Empty.......");
		}
		
		
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);
		}
		
		else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			 root.data = minValue(root.right);
			 root.right = deleteNode(root.right, root.data);

		}
		  return root;
		}
	 private int minValue(Node root) {
	        int minv = root.data;
	        while (root.left != null) {
	            minv = root.left.data;
	            root = root.left;
	        }
	        return minv;
	    }
	

	
}
