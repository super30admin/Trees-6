/*
// Time Complexity : O(N)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Go through each child and check if it lies between the range and add
If the left childe is smaller than low dont visit
if the right child is larger than high dont visit.
*/
#include<iostream>
#include<vector>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    int res{};
    int low{};
    int high{};
    void dfs(TreeNode* node){
        //base case
        if(node == NULL){
            return ;
        }
        if(node->val >= low && node->val<=high){
            res+=node->val;
        }
        //left child
        if(node->val > low){
            dfs(node->left);
        }
        //right child
        if(node->val<=high){
            dfs(node->right);
        }
    }
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        this->low = low;
        this->high = high;
        dfs(root);
        return res;
    }
};
