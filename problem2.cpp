/*
// Time Complexity : O(N) number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
For desiralize you first find out if a node exist. 
Then assign their children and then push into queue
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Codec {
    const int null_val{1001};
    const string null_string{"FFFF"};
    const int wordlen{4};
    const int num_cons{48};
    const int char_cons{55};
    vector<char>int2char{
        '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
    };
    vector<int>char2int{};
    string val2str(int val){
        if(val == null_val) return null_string;
        string res{"0000"};
        bool flag{val>=0};
        val = abs(val);
        for(int i{3};val!=0;--i){
            int idx = val%16;
            res.at(i) = int2char.at(idx);
            val = val/16;
        }
        res.at(0) = flag?'P':'N';
        return res;
    }
    int str2val(const string& str){
        if(str == null_string){
            return null_val;
        }
        int val{};
        for(int i{1};i<wordlen;++i){
            char ch{str.at(i)};
            int gg{};
            if(isdigit(ch)){
                gg = ch - num_cons;
            }
            else if(isalpha(ch)){
                gg = ch - char_cons;
            }
            val = val*16 + gg;
        }
        if(str.at(0) == 'N') return -1*val;
        return val;
    }

public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        
        string res{};
        queue<TreeNode*> q{};
        q.push(root);
        while(!q.empty()){
            int sz = q.size();
            for(int i{};i<sz;++i){
                TreeNode* temp = q.front();
                q.pop();
                if(temp == NULL){
                    res+=val2str(null_val);
                    continue;
                }
                else{
                    res+=val2str(temp->val);
                    q.push(temp->left);
                    q.push(temp->right);
                }
            }
        }
        cout<<res<<endl;
        return res;

    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        TreeNode* root = NULL;
        if(data == null_string) return root;
        int idx{};
        root = new TreeNode(str2val(data.substr(idx,wordlen)));
        idx+=wordlen;
        int data_sz = data.size();
        queue<TreeNode*> q{};
        q.push(root);
        while(!q.empty() && idx<data_sz){
            int qsize = q.size();
            for(int i{};i<qsize;i++){
                TreeNode* node = q.front();
                q.pop();
                string l_string = data.substr(idx,wordlen);
                idx+=wordlen;
                int l_val = str2val(l_string);
                //left child
                if(l_val != null_val){
                    node->left = new TreeNode(l_val);
                    q.push(node->left);
                }
                //right child
                string r_string = data.substr(idx,wordlen);
                idx+=wordlen;
                int r_val = str2val(r_string);
                if(r_val != null_val){
                    node->right = new TreeNode(r_val);
                    q.push(node->right);
                }
            }
        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));