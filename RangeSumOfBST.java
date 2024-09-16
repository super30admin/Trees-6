//DFS approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //Time Complexity: 0(n) where n is the no. of nodes
    //Space Complexity: 0(h) where h is the height of the tree
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No
    //In brief Explain your approach:

    int sum;    //it store the total sum between the range
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        dfs(root, low, high);   //doing a DFS

        return sum;
    }

    public void dfs(TreeNode root, int low, int high){
        //base
        if(root == null){
            return;
        }
        //logic
        if(root.val >= low && root.val <= high){    //Doing a preorder traversal. It's preorder because I am calculating the sum or traversing the root first then left then right
            sum = sum + root.val;
        }
        if(root.val > low){ //Optimization. If the current value if greater than the low, than there is no point in exploring the child as per the property of BST
            dfs(root.left, low, high);  //calling left node
        }
        if(root.val < high){    //Optimizing as of above
            dfs(root.right, low, high);
        }
    }
}

//Iterative Version

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        s.push(root);

        while(!s.isEmpty()){
            root = s.pop();
            if(root.val >= low && root.val <= high){
                sum = sum + root.val;
            }
            if(root.left != null && root.val > low){
                s.push(root.left);
            }
            if(root.right != null && root.val < high){
                s.push(root.right);
            }
        }

        return sum;
    }
}