/***Time Complexity (TC):** O(N log N)

**Space Complexity (SC):** O(N)

Where:
- `N` is the number of nodes in the binary tree.*/
class Solution {
public:
    map<int, map<int, vector<int>>> mp;
    void helper(TreeNode* root, int row, int col) {
        if(!root) return;
        mp[col][row].push_back(root->val);
        helper(root->left, row+1, col-1);
        helper(root->right, row+1, col+1);
    }
    vector<vector<int>> verticalOrder(TreeNode* root) {
        if(!root) return {};
        helper(root, 0, 0);
        vector<vector<int>> ans;
        for(auto itr=mp.begin();itr!=mp.end();itr++) {
            auto tp = itr->second;
            vector<int> a;
            for(auto it=tp.begin();it!=tp.end();it++) {
                for(auto &x : it->second) {
                    a.push_back(x);
                }
            }
            ans.push_back(a);
        }
        return ans;
    }
};