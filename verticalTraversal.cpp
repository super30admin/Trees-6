/*
Intuition: First we will keep a track of the horizontal distance for each node.
For example: root node will have a horizontal distance of 0. its left node will have a HD of -1
and right node will have a HD of 1.
Level Order will be the easiest. 

Time Complexity: O(N), N = Number of nodes.
Space Complexity: O(N), N = Number of nodes.

*/
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> result;
        if ( root == NULL) return result;

        map<int, vector<int>> map;
        queue<pair<TreeNode*,int>>queue;
        queue.push({root, 0});
        int minHD = 0, maxHD = 0;
        while ( queue.size() != 0){
            
            auto currPair = queue.front();
            queue.pop();
            
            TreeNode* currNode = currPair.first;
            int HD = currPair.second;
            
            minHD = min(minHD, HD);
            maxHD = max(maxHD, HD);
            if ( map.find(HD) == map.end()){
                vector<int> partialResult;
                map[HD] = partialResult;
            }
            map[HD].push_back(currNode->val);
            
            if ( currNode->left != NULL) queue.push({currNode->left, HD-1});
            if ( currNode->right != NULL) queue.push({currNode->right, HD+1});

        }
        for ( int i = minHD; i <=maxHD; i++){
            result.push_back(map[i]);
        }
        return result;
    }
};