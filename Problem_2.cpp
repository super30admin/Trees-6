297. Serialize and Deserialize Binary Tree

Time complexity:
O(N)

Space complexity:

O(N)

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
    string serialize(TreeNode* root) 
    {
        if(!root)
        {
            return "";
        }    
        string s = "";
        queue<TreeNode *>q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode * temp =  q.front();
            q.pop();
            if(temp == NULL)
            {
                s.append("#,");
            }
            else
            {
                s.append(to_string(temp->val)+',');
            }
            if(temp)
            {
                q.push(temp->left);
                q.push(temp->right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) 
    {
        if(data.size() == 0)
        {
            return NULL;
        }    
        stringstream s(data);
        string str;
        getline(s, str, ',');
        TreeNode * root = new TreeNode(stoi(str));
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode * temp = q.front();
            q.pop();
            getline(s, str, ',');
            if(str == "#")
            {
                temp->left = NULL;
            }
            else
            {
                TreeNode * leftNode = new TreeNode(stoi(str));
                temp->left = leftNode;
                q.push(leftNode);
            }
            getline(s, str, ',');
            if(str == "#")
            {
                temp->right = NULL;
            }
            else
            {
                TreeNode * rightNode = new TreeNode(stoi(str));
                temp->right = rightNode;
                q.push(rightNode);
            }
        }
        return root;
    }
};



