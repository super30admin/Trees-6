//Time - O(n)
//Space - O(n)

class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {

        vector<vector<int>> ans;
        queue<pair<TreeNode*, int>> q;
        unordered_map<int, vector<int>> mainUmap;
        int x = 0;
        int minn = 0,maxx = INT_MIN;
        q.push({root,x});
        
        while(!q.empty()){
            int size = q.size();
            unordered_map<int, vector<int>> umap;
            for(int i=0;i<size;i++){
                pair<TreeNode*, int> p = q.front();q.pop();
                TreeNode* node = p.first;
                x = p.second;
                umap[x].push_back(node->val);
                
                maxx = max(maxx, x);
                minn = min(minn, x);
                
                if(node->left){
                    q.push({node->left,x-1});
                }
                if(node->right){
                    q.push({node->right,x+1});
                }
            }
            
            for(auto it = umap.begin();it!=umap.end();it++){
                vector<int> v = it->second;
                int col = it->first;
                sort(v.begin(), v.end());
                for(auto e:v){
                    mainUmap[col].push_back(e);
                }
            }
        }

        for(int i=minn;i<=maxx;i++){
            vector<int> vec = mainUmap[i];
            ans.push_back(vec);
        }
        
        return ans;
        
    }
};