/*
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Traverse the tree, and store the tree val in its respecting col number
Root call number 0, left child = parent -1 , right child = parent +1 
Traverse the tree and store the node val accodring to the col_number in the hashmap
from min col to max col num , store the values in the result array and then print.
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

class Qnode{
    public:
    TreeNode* node;
    int col_num;
    Qnode(TreeNode* node = NULL,int col_num = 0):node(node),col_num(col_num){}
};

class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> res{};
        if(root == NULL) return res;
        int min_col{INT_MAX};
        int max_col{INT_MIN};
        queue<Qnode> q;
        unordered_map<int,vector<int>> umap{};
        q.push(Qnode(root,0));
        while(!q.empty()){
            Qnode temp = q.front();
            q.pop();
            if(umap.find(temp.col_num) == umap.end()){
                umap[temp.col_num] = vector<int>{};
            }
            umap[temp.col_num].push_back(temp.node->val);
            min_col = min(min_col,temp.col_num);
            max_col = max(max_col,temp.col_num);
            if(temp.node->left){
                q.push(Qnode(temp.node->left,temp.col_num-1));
            }
            if(temp.node->right){
                q.push(Qnode(temp.node->right,temp.col_num+1));
            }
        }
        for(int i{min_col};i<=max_col;++i){
            res.push_back(umap[i]);
        }
        return res;
        
    }
};