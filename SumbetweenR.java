// We’re doing DFS from root and checking if the value lies within the range.
// If it does, we add it to our result, and we only explore left if it can have smaller values and right if it can have larger ones and skip unnecessary subtrees.
//Time Complexity: O(n)
//Space Complexity: O(h)

import javax.swing.tree.TreeNode;

public class SumbetweenR{
   int result;
   public int rangeSumBST(TreeNode root, int low, int high){
    this.result = 0;
    dfs(root,low,high);
    return result;
   } 
   private void dfs(TreeNode root, int low, int high)
   {
        if(root==null) return;

        if(root.val>=low && root.val<=high)
        {
            result += root.val;
        }

        if(root.val>low)
        {
            dfs(root.left,low,high);
        }
        if(root.val<high)
        {
            dfs(root.right,low,high);
        }
   }
}
