// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    int res;
   public int rangeSumBST(TreeNode root, int low, int high) {
       res=0;
       dfs(root, low, high);
       return res;
   }
   
   private void dfs(TreeNode root, int low, int high){
       //base
       if(root==null)  return;
   
       //logic
       if(low<=root.val && high>=root.val){
           res+=root.val;
           
       }
       
       if(low<root.val){
           dfs(root.left,low,high);
       }
       
     
       if(root.val<high){
           
           dfs(root.right,low,high);
       }
       
       
   }
   
}