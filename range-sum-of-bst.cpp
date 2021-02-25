//Time - O(n)
//Space - O(logn)

class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(root == NULL) return 0;
        int sum = 0;
        if(root->val>=low && root->val<=high) sum = sum + root->val;
        
        if(low<root->val){
            sum = sum + rangeSumBST(root->left, low, high);
        }
        
        if(high>root->val){
            sum = sum + rangeSumBST(root->right, low, high);
        }
        
        return sum;
        
    }
};