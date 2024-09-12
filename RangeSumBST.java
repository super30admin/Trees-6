public class RangeSumBST {
    /**
     * Time COmplexity: O(n)
     * 
     * Space Complexity: Average case: O(logn)
     *    Worst case: O(n)  for a skewed tree.
     * 
     * Were you able to solve this on leetcode? Yes
     */
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        
        inOrder(root, low, high);
        return result;
    }
    
    void inOrder(TreeNode root, int low, int high){
        if(root == null) return;
        
        inOrder(root.left, low, high);
        if(root.val >= low && root.val <= high) result += root.val;
        inOrder(root.right, low, high);
    }
}
