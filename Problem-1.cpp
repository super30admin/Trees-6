/*
TC : O(n)
SC : O(h)
*/
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
class Solution
{
public:
    int total;
    int rangeSumBST(TreeNode *root, int low, int high)
    {
        if (root == nullptr)
        {
            return 0;
        }

        dfs(root, low, high);
        return total;
    }

    void dfs(TreeNode *root, int low, int high)
    {
        // base
        if (root == nullptr)
        {
            return;
        }

        // logic
        if (root->val > low)
        {
            dfs(root->left, low, high);
        }
        if (root->val >= low && root->val <= high)
        {
            total += root->val;
        }
        if (root->val < high)
        {
            dfs(root->right, low, high);
        }
    }
};