/*
**Time Complexity (TC):**
- `serialize(TreeNode* root)`: O(N)
- `deserialize(string data)`: O(N)

**Space Complexity (SC):**
- `serialize(TreeNode* root)`: O(N)
- `deserialize(string data)`: O(N)

Where:
- `N` is the number of nodes in the binary tree.
*/

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(!root) return "N";
        return to_string(root->val) + " " + serialize(root->left) + " " + serialize(root->right);
    }

    TreeNode *helper(stringstream &ss) {
        string str;
        ss >> str;
        if(str == "N") {
            return NULL;
        }
        TreeNode *root = new TreeNode(stoi(str));
        root->left = helper(ss);
        root->right = helper(ss);
        return root;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        return helper(ss);
    }
};
