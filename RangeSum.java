/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h), h is the height of the tree
 */
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;

    }

    void dfs(TreeNode node, int low, int high){
        if(node.val >= low && node.val <= high){
            sum += node.val;
        }

        if(node.left != null){
            dfs(node.left, low, high);
        }
        if(node.right != null){
            dfs(node.right, low, high);
        }


    }
}