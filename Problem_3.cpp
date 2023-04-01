314. Binary Tree Vertical Order Traversal


TC O(n)
SC O(n)

vector<vector<int>> verticalOrder(TreeNode* root) {
        map<int,vector<int>> m;
        queue<pair<TreeNode*, int>> q;
        if(root) q.push({root,0});
        while(!q.empty()){
            auto [node, pos] = q.front();
            m[pos].push_back(node->val);
            q.pop();
            if(node->left) q.push({node->left,pos-1});
            if(node->right) q.push({node->right,pos+1});
        }
        vector<vector<int>> res;
        for(auto& i:m) res.push_back(i.second);
        return res;
    }
