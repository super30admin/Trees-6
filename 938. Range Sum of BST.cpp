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

    TreeNode* LCA(TreeNode* root, int val1, int val2){
      if(root==nullptr)  return root;
      if(root->val>=val1 && root->val<=val2)  return root;

      return root->val >= val1 ? LCA(root->left,val1,val2) : LCA(root->right,val1,val2);
      
    }

    int trav(TreeNode* node, int low, int high){
      if(node==nullptr)  return 0;

      int ans = 0;
      if(low <= node->val && node->val <= high)  ans += node->val;

      ans += trav(node->left, low, high);
      ans += trav(node->right, low, high);

      return ans;
    }

    int rangeSumBST(TreeNode* root, int low, int high) {
        TreeNode* lca = LCA(root,low,high);
        return trav(lca,low,high);
    }
};
