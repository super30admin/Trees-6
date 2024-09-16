package S30.Trees_6;

import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity : O(n) - touching every node
Space Complexity : O(n) - Queue space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


public class SerializeDeserializeBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != null){
                sb.append(curr.val);
                sb.append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }else{
                sb.append("null");
                sb.append(",");
            }

        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        queue.offer(root);
        int i = 1;

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(!dataArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(dataArr[i]));
                queue.offer(curr.left);
            }
            i++;
            if(!dataArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(dataArr[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;


    }
}
