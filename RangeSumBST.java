import java.util.*;

public class RangeSumBST {

    // TC: O(N) At the worst case it will traverse all the nodes and compare
    // SC: O(N) In the recursion stack it will have all the nodes.
    int result;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        result = 0;
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high) {
        if (root == null)
            return;

        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        // If the low is higher than current value , we don't need to check for left
        // children
        if (low <= root.val) {
            helper(root.left, low, high);
        }
        // If the high is lesser than current value , we don't need to check for left
        // children
        if (high >= root.val) {
            helper(root.right, low, high);
        }
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        return helper2(root, low, high);
    }

    private int helper2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int currentResult = 0;
        if (low <= root.val) {
            currentResult += helper2(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        if (high >= root.val) {
            currentResult += helper2(root.right, low, high);
        }
        return currentResult;
    }

    //Pre - Order traversal - We can't put the condition as it 

    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int result = 0;
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.val >= low && current.val <=  high) {
                result += current.val;
            }
            
            if(high >= current.val && current.right != null) {
                stack.push(current.right);
            }
            
            if(low <= current.val && current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        rangeSumBST.helper(new TreeNode().getSample(), 2, 5);
    }
}
