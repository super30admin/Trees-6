/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


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
        // return bfs(root,low,high);
        return dfs(root,low,high);
    }
    
    
    int bfs(TreeNode* root, int low, int high) {
        queue<TreeNode*> q;
        q.push(root);
        int sum=0;
        while(!q.empty()) {
            auto node = q.front();q.pop();
            if(node->val >= low and node->val <= high) {
                sum += node->val;
            }
            
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
        }
        return sum;
    }
    
    int dfs(TreeNode* root, int low, int high) {
        stack<TreeNode*> st;
        st.push(root);
        int ans = 0;
        while(!st.empty()) {
            auto node = st.top();st.pop();
             if(node->val >= low and node->val <= high) {
                ans += node->val;
            }
            
            if(node->left) st.push(node->left);
            if(node->right) st.push(node->right);
        }
        
        return ans;
    }
    
};