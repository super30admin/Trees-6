// Time Complexity: O(N) where N is the number of nodes in the binary tree
// Space Complexity: O(h) where h is the stack space
// Were you able to run the code on Leetcode: Yes
// Any problem you faced while coding this: No


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {

        if (!root) return 0;

        // Calculate the sum of the root node if it is within the range
        int currentVal = (root->val >= low && root->val <= high) ? root->val : 0;
        
        // Recursively calculate the sum for the left and right subtrees
        int leftSum = rangeSumBST(root->left, low, high);
        int rightSum = rangeSumBST(root->right, low, high);
        
        // Return the sum of the current node and the sums of the left and right subtrees
        return currentVal + leftSum + rightSum;
    }

private:
    void dfs(TreeNode* root, int& runningSum, int low, int high) {
        // base case
        if (!root) return;


        // check if the current node is within the range to add the value to the sum
        if(root->val >= low && root->val <= high){
            runningSum += root->val;
        }
        

        // search left subtree if it exists when the lower bound is less than current node val
        if (low < root->val) {
            if (root->left) dfs(root->left, runningSum, low, high);
        }
        // else search right subtree if it exists
        else {
            if (root->right) dfs(root->right, runningSum, low, high);
        }

        // search right subtree if it exists when the upper bound is greater than current node val
        if (high > root->val) {
            if (root->right) dfs(root->right, runningSum, low, high);
        }
        // else search left subtree if it exists
        else {
            if (root->left) dfs(root->left, runningSum, low, high);
        }


    }
};