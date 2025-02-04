// Time Complexity O(n) worst case and best case O(log n)
// Space Complexity O(n) for stack space

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBFSIterative {
    public int rangeSumIterativeBFS(TreeNode root, int low, int high){
        if( root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while( !queue.isEmpty()){
            TreeNode curr = queue.poll();
            if( curr == null ) continue;
            if( curr.val >= low && curr.val <= high){
                sum += curr.val;
            }
            if(curr.val > low) queue.add(curr.left);
            if( curr.val < high) queue.add(curr.right);
        }
        return sum;

    }
    public static void main ( String [] args ){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        RangeSumBFSIterative solution = new RangeSumBFSIterative();
        int low = 7, high = 15;

        int result = solution.rangeSumIterativeBFS(root, low, high);
        System.out.println("Sum of values in range [" + low + ", " + high + "] is: " + result);
    }
}

