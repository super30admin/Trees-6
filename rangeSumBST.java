//APPROACH 1: recursive
//time complexity O(n)
//space complexity O(1)

class Solution {
    int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        dfs(root, L, R);
        return result;
    }

    private void dfs(TreeNode root, int L, int R){
        //base
        if(root == null) return;
        //logic
        if(root.val >= L && root.val <= R){
            result += root.val;
        }
        if(root.val >= L){
            dfs(root.left, L, R);
        }
        if(root.val <= R){
            dfs(root.right, L, R);
        }
    }
}

//APPROACH 2: iterative
//time complexity O(n) since in worst case we will be touching each node once
//space complexity O(1)

class Solution {
    int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(root.val >= L && root.val <= R){
                result += root.val;
            }
            root = root.right;
        }
        return result;
    }
}
