// Time Complexity - O(n), n is the number of nodes in the tree.
// Space Complexity - O(2n)[map + queue] ~ O(n), n is the number of nodes in the tree.
// Runs on Leetcode!

class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> answer;
        if(!root)
            return answer;
        queue<pair<TreeNode*, int>> myQ;
        unordered_map<int, vector<int>> myMap;
        
        myQ.push({root, 0});
        int minC = 0; int maxC = 0;
        while(!myQ.empty()){
            pair currPair = myQ.front(); myQ.pop();
            myMap[currPair.second].push_back(currPair.first->val);
            
            if(currPair.first->left){
                myQ.push({currPair.first->left, currPair.second - 1});
                minC = min(minC, currPair.second - 1);
            }
            if(currPair.first->right){
                myQ.push({currPair.first->right, currPair.second + 1});
                maxC = max(maxC, currPair.second + 1);
            }
        }
        
        for(int i = minC; i <= maxC; i++)
            answer.push_back(myMap[i]);
        
        return answer;
    }
};

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