
//Iterative DFS Solution
class Solution {
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            if(curr == null) continue;
            if(curr.val >= low && curr.val <= high){
                result += curr.val;
            }
            if(curr.val > low){
                s.add(curr.left);
            }
            if(curr.val < high){
                s.add(curr.right);
            }
            
        }
        return result;
        
    }
}

//Recurisve SOLUTION

class Solution {
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return result;
    }
    
    private void dfs(TreeNode root, int low , int high){
        if(root == null){
            return;
        }
        if(root.val >= low && root.val <= high){
            result = result + root.val;
        }
        
        if(root.val > low){
            dfs(root.left, low,high);
        }
        
        if(root.val < high){
            dfs(root.right, low,high);
        }
    }
}