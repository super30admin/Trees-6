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

    //Approach 6, in-order traversal, return int, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root  == null) return 0;                                     //if root is null, return 0
        return helper(root, low, high);                                 //call the helper function on root
    }

    private int helper(TreeNode node, int low, int high){

        if(node == null ) return 0;                                     //check if node is null, then return 0

        int left = 0;
        if(node.val > low){                                            //check if root.val is greater than low, then only call helper function on node's left children and store the result in left variable
            left = helper(node.left, low, high);
        }

        int val = 0;
        if(node.val >= low && node.val <= high){                        //check if node's val is in between low and high, if so then store the result in val variable'
            val = node.val;
        }

        int right = 0;
        if(node.val < high){                                            //check if node's val is lower than high, then call the recursive function on node' right children and store result in right variable
            right = helper(node.right, low, high);
        }
        return val + left + right;                                      //return the left + val+ right
    }



    //Approach 5, pre-order traversal, return int, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    // public int rangeSumBST(TreeNode root, int low, int high) {

    //     if(root  == null) return 0;
    //     return helper(root, low, high);
    // }

    // private int helper(TreeNode node, int low, int high){

    //     if(node == null ) return 0;

    //     int val = 0;
    //     if(node.val >= low && node.val <= high){
    //         val = node.val;
    //     }

    //     int left = 0;
    //     if(node.val > low){
    //         left = helper(node.left, low, high);
    //     }

    //     int right = 0;
    //     if(node.val < high){
    //         right = helper(node.right, low, high);
    //     }
    //     return val + left + right;
    // }





    //Approach 4, post-order traversal, return int, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    // public int rangeSumBST(TreeNode root, int low, int high) {

    //     if(root  == null) return 0;
    //     return helper(root, low, high);
    // }

    // private int helper(TreeNode node, int low, int high){

    //     if(node == null ) return 0;

    //     int left = 0;
    //     if(node.val > low){
    //         left = helper(node.left, low, high);
    //     }

    //     int right = 0;
    //     if(node.val < high){
    //         right = helper(node.right, low, high);
    //     }

    //     int val = 0;
    //     if(node.val >= low && node.val <= high){
    //         val = node.val;
    //     }
    //     return val + left + right;
    // }







    //Approach 3, post-order traversal, return void, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    // int result = 0;

    // public int rangeSumBST(TreeNode root, int low, int high) {

    //     if(root  == null) return 0;
    //     helper(root, low, high);
    //     return result;
    // }

    // private void helper(TreeNode node, int low, int high){

    //     if(node == null ) return;

    //     if(node.val > low){
    //         helper(node.left, low, high);
    //     }

    //     if(node.val < high){
    //         helper(node.right, low, high);
    //     }

    //     if(node.val >= low && node.val <= high){
    //         result += node.val;
    //     }
    // }




    //Approach 2, inorder traversal, return void, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    // int result = 0;

    // public int rangeSumBST(TreeNode root, int low, int high) {

    //     if(root  == null) return 0;
    //     helper(root, low, high);
    //     return result;
    // }

    // private void helper(TreeNode node, int low, int high){

    //     if(node == null ) return;


    //     if(node.val > low){
    //         helper(node.left, low, high);
    //     }

    //      if(node.val >= low && node.val <= high){
    //         result += node.val;
    //     }

    //     if(node.val < high){
    //         helper(node.right, low, high);
    //     }
    // }




    //Approach 1, PreOrder Traversal, return void, recursive approach
    //Time Complexity: O(n)
    //Space Compleixty: O(n)

    // int result = 0;

    // public int rangeSumBST(TreeNode root, int low, int high) {

    //     if(root  == null) return 0;
    //     helper(root, low, high);
    //     return result;
    // }

    // private void helper(TreeNode node, int low, int high){

    //     if(node == null ) return;

    //     if(node.val >= low && node.val <= high){
    //         result += node.val;
    //     }

    //     if(node.val > low){
    //         helper(node.left, low, high);
    //     }

    //     if(node.val < high){
    //         helper(node.right, low, high);
    //     }
    // }
}


public class RangeSumOfBSTLC938 {
}
