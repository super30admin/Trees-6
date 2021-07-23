/*
Intuition: Use any type of traversal with either recursion or iterative solution.
We can stop exploring a certain path with conditions as it is a BST.

Time Complexity: O(N), N = number of nodes in the tree
Space Complexity: O(H), Height of stack

*/

//Inorder Traversal Without Conditions. (Recursive)
class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
        helper(root->left, low, high); //Left
        
        if (root->val >= low and root->val <= high){ // Process the Node
            result += root->val;
        }

        helper(root->right, low, high); //Right
    }
};


//Inorder Traversal Without Conditions.(Recursive)
class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
        if (root->val >= low and root->val <= high){ //Process the node
            result += root->val;
        }
        
        helper(root->left, low, high); // Left
        helper(root->right, low, high); //Right
    }
};


//PostOrder Traversal Without Conditions. (Recursive)

class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
        helper(root->left, low, high); //Left

        helper(root->right, low, high); //Right 
        if (root->val >= low and root->val <= high){ //Process the node
            result += root->val;
        }
    }
};


//Inorder Traversal with Conditions. (Recursive)

class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
        if ( root->val > low) helper(root->left, low, high); //Left with conditions

        if (root->val >= low and root->val <= high){ //Process the node
            result += root->val;
        }
        
        if ( root->val < high) helper(root->right, low, high); //Right with conditions
        
    }
};


//Preorder Traversal with Conditions. (Recursive)
class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
        if (root->val >= low and root->val <= high){
            result += root->val;
        }
        
        if ( root->val > low) helper(root->left, low, high);

        if ( root->val < high) helper(root->right, low, high);
        
    }
};

//PostORder Traversal with Conditions. (Recursive)
class Solution {
public:
    int result = 0;
    int rangeSumBST(TreeNode* root, int low, int high) {
        helper(root, low, high);
        return result;
    }
    void helper(TreeNode* root, int low, int high){
        if (root == NULL) return;
        
       
        
        if ( root->val > low) helper(root->left, low, high);

        if ( root->val < high) helper(root->right, low, high);
        
         if (root->val >= low and root->val <= high){
            result += root->val;
        }
        
    }
};


//Inorder Iterative
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        stack<TreeNode*>stack;
        int result = 0;
        while(stack.size() != 0 or root != NULL){
            //go to left
            while( root != NULL){
                stack.push(root);
                root = root->left;
            }
            //process root
            root = stack.top();
            stack.pop();
            if ( root->val >= low and root->val <=high){
                result += root->val;
            }
            //right
            root = root->right;
        }
        return result;
    }
};

//Preorder Iterative
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int result = 0;
        stack<TreeNode*> stack;
        stack.push(root);
        while ( stack.size() != 0){
            root = stack.top();
            stack.pop();
            //Process root
            if ( root->val >= low and root->val <= high){
                result += root->val;
            }
            
            if ( root->left != NULL) stack.push(root->left); //left
            if ( root->right != NULL) stack.push(root->right); //right
            
            
            
        }
        return result;
    }
};

//Preorder Iterative with conditions

class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int result = 0;
        stack<TreeNode*> stack;
        stack.push(root);
        while ( stack.size() != 0){
            root = stack.top();
            stack.pop();
            
            if ( root->val >= low and root->val <= high){
                result += root->val;
            }
            
            if ( root->val > low and root->left != NULL) stack.push(root->left);
            if ( root->val < high and root->right != NULL) stack.push(root->right);
            
            
            
        }
        return result;
    }
};

