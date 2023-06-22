/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

// Approach 1
// Time Complexity - O(n), n is the number of nodes in the BST.
// Space Complexity - O(n), recursive stack space.
class Solution {
    void dfs(TreeNode* root, int& low, int& high, int& sum){
        // base
        if(!root)
            return;
        
        // logic
        if(root->val >= low && root->val <= high)
            sum += root->val;
        
        dfs(root->left, low, high, sum);
        dfs(root->right, low, high, sum);
    }
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;
        dfs(root, low, high, sum);
        return sum;
    }
};

// Approach 2
// Time Complexity - O(n), n is the number of nodes in the BST.
// Space Complexity - O(n), queue space.
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        queue<TreeNode*> myQ;
        myQ.push(root);
        int sum = 0;
        while(!myQ.empty()){
            TreeNode* curr = myQ.front(); myQ.pop();
            if(curr->val >= low && curr->val <= high)
                sum += curr->val;
            
            if(curr->left)
                myQ.push(curr->left);
            if(curr->right)
                myQ.push(curr->right);
        }
        
        return sum;
    }
};

// Approach 3 ~ Approach 2 but slightly more optimised.
// Time Complexity - O(n), n is the number of nodes in the BST.
// Space Complexity - O(n), queue space.
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        queue<TreeNode*> myQ;
        myQ.push(root);
        int sum = 0;
        while(!myQ.empty()){
            TreeNode* curr = myQ.front(); myQ.pop();
            if(curr->val >= low && curr->val <= high)
                sum += curr->val;
            
            if(curr->val >= low){
                if(curr->left)
                    myQ.push(curr->left);
            }
            if(curr->val <= high){
                if(curr->right)
                    myQ.push(curr->right);
            }
        }
        
        return sum;
    }
};

// Approach 4 ~ Approach 1 but slightly more optimised.
// Time Complexity - O(n), n is the number of nodes in the BST.
// Space Complexity - O(n), queue space.
class Solution {
    void dfs(TreeNode* root, int& low, int& high, int& sum){
        // base
        if(!root)
            return;
        
        // logic
        if(root->val >= low && root->val <= high)
            sum += root->val;
        if(root->val > low)
            dfs(root->left, low, high, sum);
        
        if(root->val < high)
            dfs(root->right, low, high, sum);
    }
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;
        dfs(root, low, high, sum);
        return sum;
    }
};