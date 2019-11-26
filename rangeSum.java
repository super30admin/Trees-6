//Time Complexity:O(N) where N is the number of nodes in the tree
//Space Complexity:O(N) recursion stack
//Approach: A simple Dfs Inorder traversal of the tree would yield the answer. Whenever a value in the the range between L and R is met, it'll be added to the sum and at the end the sum value will be returned.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        //sanity check
        if(root==null){
            return 0;
        }
        //calling the helper function
        dfs(root,L,R);
        return sum;
    }
    public void dfs(TreeNode node,int L,int R){
        //sanity check
        if(node==null){
            return;
        }
        //inorder traversal of the tree
        //visiting the left subtree first
        if(node.left!=null){
            dfs(node.left,L,R);
        }
        //finding the node value in the range between L and R and adding it to sum
         if(node.val>=L&&node.val<=R){
            sum+=node.val;
        }
        //visiting the right subtree
        if(node.right!=null){
            dfs(node.right,L,R);
        }
        
    }
}