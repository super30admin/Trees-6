//DFS
//Time Complexity : O(n)
//Space Complexity : O(h), h is the height of the tree
class Solution {
    int result=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        dfs(root,low,high);
        return result;
    }
    public void dfs(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        //check if the curr node's val lies within the range, if so add it to the result
        if(root.val>=low && root.val<=high){
            result += root.val;
        }
        //if the curr node's value is greater than low, visit the left side of the tree
        if(root.val >= low){
            dfs(root.left, low, high);
        }
        //if the curr node's value is less than high, visit the left side of the tree
        if(root.val<=high){
            dfs(root.right,low,high);
        }
    }
}
//iterative
//Time Complexity : O(n)
//Space Complexity : O(h), h space is consumed by the recussion stack
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result=0;
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            
            TreeNode cur = stack.pop();
            if(cur!=null){
                if(cur.val>=low && cur.val<=high){
                    result += cur.val;
                }
                if(cur.val>low){
                    stack.push(cur.left);
                }
                if(cur.val<high){
                    stack.push(cur.right);
                }
            }
        }
        return result;
    }
}