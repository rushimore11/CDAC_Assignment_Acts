package bt_height_Q1;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public static class TreeNode{
        int data;
        TreeNode right;
        TreeNode left;

        public TreeNode(int data){
            this.data = data;
            right = null;
            left = null;
        }
    }
    TreeNode root=null;

    public BinaryTree(int[] arr) {
        if (arr != null && arr.length > 0) {
            int[] index = {0}; 
            this.root = buildFromPreorder(arr, index);
        }
    }
    private TreeNode buildFromPreorder(int[] arr, int[] index) {
        if (index[0] >= arr.length) {
            return null;
        }

        int currVal = arr[index[0]++];
        if (currVal == -1) {
            return null;
        }

        TreeNode node = new TreeNode(currVal);
        node.left = buildFromPreorder(arr, index);
        node.right = buildFromPreorder(arr, index);
        return node;
    } 
    public int heightOfTree(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(heightOfTree(root.right),heightOfTree(root.left))+1;
    }   
}
