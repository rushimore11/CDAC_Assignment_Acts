package binaryTreeImplementation;

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

    public void printPreorder(TreeNode root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);

    }

    public void printInorder(TreeNode root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public void printlnPostorder(TreeNode root){
        if(root == null){
            return;
        }
        printlnPostorder(root.left);
        printlnPostorder(root.right);
        System.out.print(root.data+" ");
    }

    public List<Integer> levelOrder(TreeNode root){
        List<Integer>levelOrder = new LinkedList<>();
        if(root == null){
            return levelOrder;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int NodeAtlevel = queue.size();

            List<Integer>subList = new LinkedList<>();
            for(int i=0;i<NodeAtlevel;i++){
               TreeNode curr = queue.poll();
               subList.add(curr.data);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            levelOrder.addAll(subList);
        }
        return levelOrder;
    }
    public int countNodes(TreeNode root ){
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right)+1;
    }

    public int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(heightOfTree(root.right),heightOfTree(root.left))+1;
    }

    public int countLeafNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public int countNodesWithValue(TreeNode root , int value){
        if(root == null){
            return 0;
        }
        int match = (root.data == value)?1:0;
        return countNodesWithValue(root.left, value) + countNodesWithValue(root.right,value)+match;
    }
}
