/*
Time: O(n)
Space: O(row*col)

The only trick here is that for nodes having same (row,col) position,  we can't just have them left to right, we need to have them sorted
So, for every recursive call, maintain (row, col) information and add values to that m[col][row] vector
Then traverse col by col (from min to max), row by row (from 0 to rows) but make sure that for every row, the vector of values is sorted

*/

class Solution {
public:
    int mini = 1e9, maxi = -1e9, rows = 0;
    unordered_map<int,unordered_map<int,vector<int>>> m;

    //for nodes having same (row,col) position,  we can't just have them left to right, we need to have them sorted
    //So, for every recursive call, maintain (row, col) information and add values to that m[col][row] vector
    void call(TreeNode* node, int row, int col){
        if(node == nullptr)  return;

        //maintain minimum and maximum col (and row) position for later use
        mini = min(mini, col);
        maxi = max(maxi, col);
        rows = max(rows, row);

        m[col][row].push_back(node->val); //if we didn't need to sort values in same (col,row) position, we could have just appended the value in its column vector
        
        call(node->left, row+1, col-1);
        call(node->right, row+1, col+1);
    }

    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ret;

        call(root, 0, 0);

        //traverse col by col (from min to max), row by row (from 0 to rows) but make sure that for every row, the vector of values is sorted
        for(int i=mini;i<=maxi;i++){
            //sort(m[i].begin(), m[i].end());
            vector<int> vals;
            for(int j=0;j<=rows;j++){
                sort(m[i][j].begin(), m[i][j].end());
                for(auto u: m[i][j])  vals.push_back(u);
            }
            ret.push_back(vals);
        }

        return ret;
    }
};
