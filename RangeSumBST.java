public class RangeSumBST {
   

    //TC: O(N) At the worst case it will traverse all the nodes and compare
    //SC: O(N) In the recursion stack it will have all the nodes.
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        result = 0;
        helper(root, low, high);
        return result;
    }
    
    private void helper(TreeNode root, int low, int high) {
        if(root == null) return;
        
        if(root.val >=low && root.val <=high) {
            result += root.val;
        }
        
        //If the low is higher than current value , we don't need to check for left children
        if(low <= root.val) {
            helper(root.left, low, high);    
        }
        
        //If the high is lesser than current value , we don't need to check for left children
        if(high >= root.val) {
            helper(root.right, low, high);    
        }
    }
    
    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        rangeSumBST.helper(new TreeNode().getSample(), 2, 5);
    }
}
