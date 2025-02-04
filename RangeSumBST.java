// Time Complexity : Worst case O(n) and best case is O(log n)
// Space Complexity: Recursive stack space O(n)
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
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high){
        if( root == null) return 0;
        if ( root.val < low ){
            return rangeSumBST(root.right, low, high); // explore only right subtree
        } else if( root.val > high){
            return rangeSumBST(root.left, low, high); // explore only left subtree
        } else{
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

        }

    }
    public static void main ( String [] args ){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        RangeSumBST solution = new RangeSumBST();
        int low = 7, high = 15;

        int result = solution.rangeSumBST(root, low, high);
        System.out.println("Sum of values in range [" + low + ", " + high + "] is: " + result);
    }
}
