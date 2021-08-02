//time: O(n) where n = number of nodes in the tree
//space: O(n) for the recursive stack
//did it run successfully on leetcode: yes
class RangeSumBST {
  
    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        //if root is null
        if(root==null) return 0;
    // traverse the tree
      dfs(root, low, high);
        
        return res;
    }
    
    public void dfs(TreeNode root, int low, int high) {
        //if current node is null
        if(root==null) return;
        
        //if current node value is greater than low
        if(root.val>low)
            //traverse to left child
            dfs(root.left, low, high);
        
        //if current node value is samller than high
        if(root.val<high)
            //traverse to right child
            dfs(root.right,low,high);
        
        //if current node is in the range, add to result
        if(root.val>=low && root.val<=high) res += root.val;
            
    }
 
     
}