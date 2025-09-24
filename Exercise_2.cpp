// Time Complexity: O(N) where N is the number of nodes in the binary tree
// Space Complexity: O(h) where h is the height of the binary tree
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No

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
    int idx=0;
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (!root) return "";
        string res="";
        dfsSerialize(root, res);
        // remove last trailing comma
        res = res.substr(0,res.size()-1);
        // cout<<res;
        return res;
        
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if (data=="") return nullptr;
        
        // split string into array based on commas
        vector<string> splitArr;
        stringstream ss(data);
        string token;
        while (getline(ss, token, ',')) {
            splitArr.push_back(token);
        }
        // for (auto &it: splitArr){
        //     cout<<it<<" ";
        // }

        // initialize index to zero and build tree recursively
        int idx=0;
        return dfsDeserialize(splitArr);
    }
private:
    void dfsSerialize(TreeNode* root, string& s) {
        // base case when root is null
        if (!root){
            // add # to represent null and return
            s += "#,";
            return;
        }
        // performing preorder traversal
        // convert node value to string with comma
        s+= to_string(root->val)+",";
        // recursively traverse left and right subtree
        dfsSerialize(root->left, s);
        dfsSerialize(root->right, s);
    }

    TreeNode* dfsDeserialize(vector<string>& treeArr) {
        // base case
        if (treeArr[idx] == "#"){
            // this indicates null pointer
            idx++;
            return nullptr;
        } 
        // performing preorder traversal
        TreeNode* newRoot = new TreeNode(stoi(treeArr[idx]));
        // increment index to move string ahead after current node is processed
        idx++;
        // recursively traverse left and right subtree
        newRoot->left = dfsDeserialize(treeArr);
        newRoot->right = dfsDeserialize(treeArr);

        return newRoot;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));