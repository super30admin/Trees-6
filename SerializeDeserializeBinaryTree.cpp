// Time Complexity - O(n), n is the number of nodes in the tree.
// Space Complexity - O(n), n is the number of nodes in the tree.
// Runs on Leetcode!

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(!root)
            return "null";
        string srlzd = "";
        queue<TreeNode*> myQ;
        myQ.push(root);
        
        while(!myQ.empty()){
            TreeNode* curr = myQ.front(); myQ.pop();
            if(curr){
                int currVal = curr->val;
                srlzd += to_string(currVal);
                myQ.push(curr->left);
                myQ.push(curr->right);
            }
            else
                srlzd += "null";
            srlzd += ",";
        }
        srlzd.pop_back();
        return srlzd;
    }

    vector<string> splitString(string s){
        vector<string> result;
        int l = s.size();
        string curr = "";
        for(int i = 0; i < l; i++){
            if(s[i] != ',')
                curr += s[i];
            if(s[i] == ',' || i == l-1){
                result.push_back(curr);
                curr = "";
            }
        }
        return result;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data == "null" || data.length() == 0)
            return NULL;
        vector<string> nodes = splitString(data);
        
        int idx = 1;
        TreeNode* root = new TreeNode(stoi(nodes[0]));
        queue<TreeNode*> myQ;
        myQ.push(root);
        
        while(!myQ.empty() && idx < nodes.size()){
            TreeNode* curr = myQ.front(); myQ.pop();
            if(nodes[idx] != "null"){
                curr->left = new TreeNode(stoi(nodes[idx]));
                myQ.push(curr->left);
            }
            idx++;
            
            if(nodes[idx] != "null"){
                curr->right = new TreeNode(stoi(nodes[idx]));
                myQ.push(curr->right);
            }
            idx++;
        }
        
        return root;
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));