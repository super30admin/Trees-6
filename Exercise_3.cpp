// Time Cmplexity: O(N) where N is the number of nodes in the binary tree
// Space Complexity: O(N) where N is the number of nodes in the binary tree
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No

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
class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        if (!root) return {};

        vector<vector<int>> result;
        // store nodes for each X coordinate
        unordered_map<int, vector<int>> cols;
        // store nodes in level order
        queue<pair<TreeNode*, int>> q;

        int minX=0, maxX=0;

        // Process the tree level order
        q.push({root, 0});

        while(!q.empty()) {

            auto& [node, x] = q.front();
            q.pop();
            // add node val for current X coordinate and store it in the map with corrent X position
            cols[x].push_back(node->val); 


            // if left child exists, add it to the queue
            if (node->left) {
                q.push({node->left, x-1});
                // track min and max X
                minX = min(minX, x-1);
                maxX = max(maxX, x-1);
            }
            // if right child exists, add it to the queue
            if (node->right) {
                q.push({node->right, x+1});
                // track min and max X
                minX = min(minX, x+1);
                maxX = max(maxX, x+1);
            }
        }
        // push nodes for each X coordinate starting from minX to maxX into the result array
        for(int i=minX; i<=maxX; i++) {
            result.push_back(cols[i]);
        }

        return result;

    }
};