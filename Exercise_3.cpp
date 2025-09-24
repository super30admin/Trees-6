// Time Cmplexity: O(N * k log k) where N is the number of nodes in the binary tree and k is the average elements in a column
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
        if (root == nullptr) {
            return {};
        }
        // BFS based approach
        // hashmap with the x coordinate as the key assuming that root is 0,0 and left child is -1, 1 and right child is 1, 1
        // this hashmap will store the all nodes for a given column with same x coordinate
        unordered_map<int, vector<pair<int,int>>> cols; // {x: [(y, val)]}

        // BFS queue to process nodes at each level
        queue<tuple<TreeNode*, int, int>> q; // (node, x, y)
        q.push({root, 0, 0});

        // defines range of x
        int minX=0, maxX=0;

        while (!q.empty()) {

            // get the node, x and y
            auto [node, x, y] = q.front();
            q.pop();

            // add the node to the hashmap
            cols[x].push_back({y, node->val});
            // keep tracking min and max value of x
            minX = min(minX, x);
            maxX = max(maxX, x);
            
            // add the left and right child to the queue if they exist
            if (node->left) q.push({node->left, x-1, y+1});
            if (node->right) q.push({node->right, x+1, y+1});

        }

        vector<vector<int>> res;
        // iterate starting from smallest x value to largest x
        for(int x= minX; x<=maxX; x++) {
            
            auto& col = cols[x];
            // sort the column based on y coordinate and then value
            sort(col.begin(), col.end(), [](auto& a, auto& b){
                if (a.first == b.first) return a.second<b.second;
                return a.first < b.first;
            });
            // get the values from the column and add to the result
            vector<int> vals;
            for(auto& v: col){
                vals.push_back(v.second);
            }

            res.push_back(vals);
            
        }

        return res;
    }
};