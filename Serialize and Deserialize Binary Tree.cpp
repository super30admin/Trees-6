/*
tc = N sc = N
N = nodes in tree
*/

class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(!root) return 0;
        int ans=0;
        
        if(root->val >= low && root->val<=high) {
            ans += root->val;
        }
        return ans + rangeSumBST(root->left, low, high) + rangeSumBST(root->right, low, high);
    }
};