 
/*
Time: O(n)
Space: O(h) (recursive stack space)

Serialize: 
Do pre order traversal
- For each node, encode its value -> if the node is null, encode 'end'
- For each child (left and right), recursively call the traversal (if any)


Deserialize: 
Do pre order traversal
- For each call to a function, if the data at current position doesn't hold a value, return nullptr
  If it does hold value, create a new node with that value (update current pos in data)
- Recursively call the traversal for left and right child

*/  
class Codec {
public:
    typedef TreeNode Node;

    string str;
    int pos;
    
    void call(Node* node){
        //no more child
        if(node == nullptr){
            str += "end,";
            return;
        }

        //pre order traversal
        str += to_string(node->val) + ",";
        call(node->left);
        call(node->right);
    
        
        //str += "end,"; //only needed for n-ary tree -> 2 child is fixed for binary tree
    }

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        str = "";
        
        call(root);
        cout<<str<<endl;

        return str;
    }

    int nxt(string &data, int &pos){ //pos is taken by reference
        if(data[pos] == ',') pos++;
        if(pos == data.length())  return -1005;
        if(data[pos] == 'e'){ //if 'end' found, update pos to the index after 'end'
            pos += 3;
            return -1005;
        }

        bool neg = false;
        if(data[pos] == '-'){
            neg = true;
            pos++;
        }
        
        int val = 0;
        
        while(data[pos] != ','){
            val = val * 10 + (data[pos] - '0');
            pos++;
        }

        return neg ? -val : val;
    }

    Node* build(string &data){
        int val = nxt(data, pos); 
        //cout<<val<<endl;
        
        //end of this subtree	
        if(val == -1005)  return nullptr;

        Node* node = new Node(val);
        node->left = build(data);
        node->right = build(data);
        
        /*
        (For n-ary tree)

        Node* adj = build(data);
        while(adj != nullptr){ //adj == nullptr means this subtree is done
            node->neighbors.push_back(adj);
            adj = build(data);
        }
        */

        return node;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        pos = 0;
        return build(data);
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));
