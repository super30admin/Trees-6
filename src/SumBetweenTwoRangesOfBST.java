//time complexity- O(n) where n is the total number of nodes
//space complexity- O(n)
import java.util.*;
public class SumBetweenTwoRangesOfBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stk = new Stack<>();
        int sum = 0;
        stk.push(root);
        while(!stk.isEmpty()) {
            root = stk.pop();
            // System.out.println(root.val);
            if(root.val >= low && root.val <= high) sum += root.val;

            if(root.val >= high) {
                if(root.left != null) stk.push(root.left);
            } else if(root.val <= low) {
                if(root.right != null) stk.push(root.right);
            } else {
                if(root.right != null) stk.push(root.right);
                if(root.left != null) stk.push(root.left);
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left= new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);

        /*      Tree->
                        10
                     /     \
                    5       15
                 /    \    /   \
                3     7   13   18
               /      /
             1       6
         */

        int low = 6;
        int high = 14;

        System.out.println("Sum of Nodes in range [" + low+ ", "+ high+"] is: "+ rangeSumBST(root, low, high));
    }
}
