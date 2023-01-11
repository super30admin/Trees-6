import java.util.*;

// Definition for a binary tree node.
public class TreeNode {
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
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return result;
    }

    private void helper(TreeNode root, int low, int high){
        // base
        if (root==null) return;

        // logic
        if(root.left !=null && root.val > low) {
            helper(root.left,low,high);
        }

        // st.pop()
        if(root.val >= low && root.val <= high) {
            result += root.val;
        }

        if(root.right !=null && root.val < high) {
            helper(root.right,low,high);
        }
    }
}


/*
Time Complexity: O(n)
Space Complexity: O(h) height of the tree
*/

//DFS recursive approach
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){
            return 0;
        }
        stack.push(root);
        int sum=0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    sum += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return sum;
    }
}