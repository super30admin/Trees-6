// Time Complexity O(n) worst case and best case O(log n)
// Space Complexity O(n) for stack space
import java.util.Stack;

public class RangeSumBSTDFSIterative {
    public int rangeSumIterativeDFS(TreeNode root, int low, int high){
        if( root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        while( !stack.isEmpty()){
            TreeNode curr = stack.pop();
            if( curr == null) continue;
            if( curr.val >=low &&  curr.val <= high){
                sum += curr.val;
            }
            if( curr.val > low) stack.push(curr.left);
            if( curr.val < high) stack.push(curr.right);

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

        RangeSumBSTDFSIterative solution = new RangeSumBSTDFSIterative();
        int low = 7, high = 15;

        int result = solution.rangeSumIterativeDFS(root, low, high);
        System.out.println("Sum of values in range [" + low + ", " + high + "] is: " + result);
    }
}
