/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//Time: O(n) where n is the number of nodes
//Space : O(n)
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(!root) return "";
        queue<TreeNode*> q;
        q.push(root);
        string ans;
        int count = -1;
        while(!q.empty()){
            TreeNode *curr = q.front();
            q.pop();
            if(curr != nullptr) {
                string temp = to_string(curr->val);
                ans+=temp;
                ans+=",";
                count = ans.size()-1;
            }
            else{
                ans+="null";
                ans+=",";
                continue;
            }
            q.push(curr->left);
            q.push(curr->right);
        }
        return ans.substr(0,count);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data == "null" || data.length() == 0) return nullptr;
        vector<string> str;
        istringstream f(data);
        string s;
        while(getline(f,s,',')) {
            str.push_back(s);
        }
        TreeNode* root = new TreeNode(stoi(str[0]));
        queue<TreeNode*> q;
        int i = 0;
        q.push(root);
        i++;
        while(!q.empty() and i < str.size()){
            int size = q.size();
            TreeNode *curr = q.front();
            q.pop();
            if(str[i] != "null"){
                curr->left = new TreeNode(stoi(str[i]));
                q.push(curr->left);
            }
            i++;
            if(i < str.size() and str[i] != "null"){
                curr->right = new TreeNode(stoi(str[i]));
                q.push(curr->right);
            }
            i++;
        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));