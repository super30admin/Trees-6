package S30.Trees_6;

/*
Time Complexity : O(n) - touching every node - can avoid going to some nodes using the restricting conditions
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Stack;

public class RangeSumOfBST {

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

    int sum = 0;
    public int rangeSumBSTRecursive(TreeNode root, int low, int high) {
        inorder(root,low,high);
        return sum;
    }

    public void inorder(TreeNode root, int L, int R){
        if(root == null) return;

        if(root.val >= L && root.val <= R) sum += root.val;
        if(root.val < R){
            inorder(root.right, L,R);
        }
        if(root.val > L){
            inorder(root.left, L,R);
        }
    }

    public int rangeSumBSTIterative(TreeNode root, int low, int high) {

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();

            if(root != null){
                if(root.val >= low && root.val <= high){
                    sum += root.val;
                }

                if(root.val < high){
                    stack.push(root.right);
                }
                if(root.val > low){
                    stack.push(root.left);
                }
            }
        }
        return sum;
    }

}
