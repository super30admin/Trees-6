/* 
    Time Complexity                              :  O(N) where N is the number of nodes/size of the string to deserialize
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
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(!root) return "";
        
        queue<TreeNode*> q;
        q.push(root);
        string ser = "";
        while(!q.empty()) {
            auto node = q.front();q.pop();
            if(node == nullptr) {
                ser += "null,";
                continue;
            }
            
            ser += to_string(node->val) + ',';
            q.push(node->left);
            q.push(node->right);
        }
        return ser;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data == "") return nullptr;
        int n = data.size();
        string temp = "";
        vector<string> str = stringSplit(data);
    
        TreeNode *root = new TreeNode(stoi(str[0]));
        queue<TreeNode*> q;
        q.push(root);
        int i=1;
        int sz = str.size();

        while(i<sz) {
            TreeNode *curr = q.front();q.pop();
            
            if(str[i] != "null") {
                curr->left = new TreeNode(stoi(str[i]));
                q.push(curr->left);
            }
            i++;
            
            if(i < sz and str[i] != "null") {
                curr->right = new TreeNode(stoi(str[i]));
                q.push(curr->right);
            }
            i++;
        }
        
        return root;
    }
    
    vector<string> stringSplit(string data) {
        vector<string> ans;
        string temp = "";
        for(int i=0;i<data.size();i++) {
            if(data[i] != ',') {
                temp += data[i]; 
            } else {
                ans.push_back(temp);
                temp = "";
            }
        }
        return ans;
    }
    
    
    
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));