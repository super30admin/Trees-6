/* 
 * DFS:
 *     Time Complexity: O(n) n is number of nodes
 *     Space Complexity: O(logn) height of the tree. Stack Space.
 * Worst Case: O(n) Space Complexity 
 */
class RangeSumBST {
    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.res = 0;
        dfs(root, low, high);
        return res;
    }

    public void dfs(TreeNode root, int low, int high){
        if(root == null)
            return;
        
        dfs(root.left, low, high);

        if(low <= root.val  && root.val <= high){
            res += root.val;
            System.out.println(root.val);
        }

        dfs(root.right, low, high);

    }
}


/**
 * BFS:
 *     Time Complexity: O(n) n is number of nodes
 *     Space Complexity: O(W) height of the tree. Stack Space.
 */
class RangeSumBST {
    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.res = 0;
        bfs(root, low, high);
        return res;
    }

    public void bfs(TreeNode root,int low, int high){
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(!myQueue.isEmpty()){
            TreeNode curr = myQueue.poll();
            if(curr == null)
                return;

            if(low<= curr.val && curr.val <=high)
                res += curr.val;

            if(low <= curr.val && curr.left != null){
                myQueue.add( curr.left);
            }

            if(high >= curr.val && curr.right != null){
                myQueue.add(curr.right);
            }
        }
    }
}
