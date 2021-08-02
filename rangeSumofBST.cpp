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
//Time:O(n) where n is the number of nodes
//Space: O(logn) height of the tree
class Solution {
    int sum = 0;
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(!root) return INT_MAX;
        if(root->val >=low && root->val<=high)
            sum+=root->val;
        if(root->val > low)
            rangeSumBST(root->left,low,high);
        if(root->val < high)
            rangeSumBST(root->right,low, high);
        return sum;
    }
};