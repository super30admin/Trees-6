// Time Complexity : O(n) where n is the number of nodes in the tree in both the approaches
// Space Complexity :
/*              Approach 1: Using Stack:  O(n) where n is the number of nodes in Stack
                Approach 2: Recusion: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: As we traverse the tree, check if the root.val is within the range of L and R
if yes include it in the sum. Only explore the needed nodes by comparing root.val with L and R.
*/
// APPROACH 1: STACK ITERATIVE
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
      if(root == null) return 0;
      int sum  = 0;
      Stack<TreeNode> stk = new Stack<>();
      while(root != null || !stk.isEmpty()){
          while(root != null){
              stk.push(root);
              root = root.left;                                                                             // traverse left side
          }
          root = stk.pop();
          if(root.val >= L && root.val <= R) sum+=root.val;                                                         // Check if value in range
          root = root.right;                                                                                        // Move right side
      }
        return sum;                                                                                     // Return the sum
    }
}

// APPROACH 2 : RECURISION
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
      if(root == null) return 0;
      dfs(root, L, R);                                                                              // DFS Explore start
      return sum;
    }
    private void dfs(TreeNode root, int L, int R){
        if(root == null) return;
        if(root.val >= L && root.val <= R){                                                         // if sum within the range
            sum+=root.val;
        }
        if(root.val > L){
            dfs(root.left, L, R);                                                                           // Only explore left
        }
        if(root.val < R){
            dfs(root.right, L, R);                                                                      // Only explore right if
        }
    }
}