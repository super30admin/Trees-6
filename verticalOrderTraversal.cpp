
//Time: O(n) where n is the number of nodes
//Space: O(n) Space taken by Hashmap
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
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root) return ans;
        unordered_map<int,vector<int>> hMap;
        queue<pair<TreeNode*,int>> q;
        q.push({root,0});
        int minVal = INT_MAX;
        int maxVal = INT_MIN;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                pair<TreeNode*,int> curr = q.front();q.pop();
                hMap[curr.second].push_back(curr.first->val);
                minVal = min(minVal,curr.second);
                maxVal = max(maxVal,curr.second);
                if(curr.first->left) q.push({curr.first->left,curr.second-1});
                if(curr.first->right) q.push({curr.first->right,curr.second+1});
            }
        }
        for(int i = minVal; i <= maxVal;i++){
            ans.push_back(hMap[i]);
        }
        return ans;
    }
};