//Time - O(n)
//Space - O(n)

class Codec {
public:
    
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        queue<TreeNode*> q;
        if(root == NULL) return "#";
        q.push(root);
        string str = "";
        while(!q.empty()){
            TreeNode* node = q.front();q.pop();
            str += node ? to_string(node->val)+",":"#,";
            if(node){
                q.push(node->left);
                q.push(node->right);
            }
        }
        return str;
    }
    

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        queue<TreeNode*> q;
        if(data == "#") return NULL;
        
        TreeNode* root;
        string str;
        stringstream ss(data);
        if(getline(ss, str, ',')) {
            root = new TreeNode(stoi(str));
        }

        q.push(root);
        while(!q.empty()){
            TreeNode* curr = q.front();q.pop();
            getline(ss, str, ',');
            if(str!="#"){
                curr->left = new TreeNode(stoi(str));
                q.push(curr->left);
            }
            
            getline(ss, str, ',');
            if(str!="#"){
                curr->right = new TreeNode(stoi(str));
                q.push(curr->right);
            }
            

        }
        return root;
    }
};

