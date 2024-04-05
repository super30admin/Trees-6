// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: recursion
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int sum=0;

        if(root.val>low){
            sum=sum+ rangeSumBST(root.left, low, high);
        }
        if(root.val>=low && root.val <=high){
            sum=sum+ root.val;
        }
        if(root.val<high){
            sum=sum+ rangeSumBST(root.right, low, high);
        }

        return sum;
    }
    
}