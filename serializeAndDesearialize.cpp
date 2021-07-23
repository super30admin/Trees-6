/*
Intuition: First determine how to deserialize and serialize a tree.
Level Order will be the easiest. 
Use queue to store nodes, (even NULL);

Time Complexity: O(N), N = Number of nodes.
Space Complexity: O(N), N = Number of nodes.


*/
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if ( root == NULL) return "";
        queue<TreeNode*>queue;
        queue.push(root);
        string result;
        while(queue.size()!= 0){
            auto curr = queue.front();
            queue.pop();
            
            //Two possibilites: Node is null or not.
            if ( curr!= NULL){
                result += to_string(curr->val);
                result += ",";
                queue.push(curr->left);
                queue.push(curr->right);
            }else{
                result += "null,";
            }
        }
        return result;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if ( data.size() == 0 ) return NULL;
        vector<string> stringData =split (data, ",");
        queue<TreeNode*>queue;
        int i = 0;
        auto root = new TreeNode(stoi(stringData[i]));
        queue.push(root);
        i++;
        while(queue.size()!= 0 and i < stringData.size()){
            auto curr = queue.front();
            queue.pop();
            
            //Only process nodes that are not null
            if ( stringData[i] != "null" ){
                curr->left = new TreeNode(stoi(stringData[i]));
                queue.push(curr->left);
            }
            i++;
            if ( stringData[i] != "null" ){
                curr->right = new TreeNode(stoi(stringData[i]));
                queue.push(curr->right);
            }
            i++;
            
            
        }
        return root;
    }
    vector<string> split (string s, string delimiter) {
        //Splitting a string at ','
        size_t pos_start = 0, pos_end, delim_len = delimiter.length();
        string token;
        vector<string> res;

        while ((pos_end = s.find (delimiter, pos_start)) != string::npos) {
            token = s.substr (pos_start, pos_end - pos_start);
            pos_start = pos_end + delim_len;
            res.push_back (token);
        }

        res.push_back (s.substr (pos_start));
    return res;
}
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));