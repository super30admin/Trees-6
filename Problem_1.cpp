938. Range Sum of BST

TC -O(n)
SC - O(n)

class Solution {
public:
    int solve(TreeNode* curr, int& low, int& high)
    {
        if (curr == NULL) return 0;
        
        int ans = 0;
        bool isInRange = false;
        if (curr->val >= low && curr->val <= high) 
        {
            isInRange = true;
            ans += curr->val;
        }
        
        if (isInRange || (curr->val <= low)) ans += solve(curr->right, low, high);
        if (isInRange || (curr->val >= high)) ans += solve(curr->left, low, high);
        return ans;
    }
    int rangeSumBST(TreeNode* root, int low, int high) 
    {
        return solve(root, low, high);
        
    }
};
