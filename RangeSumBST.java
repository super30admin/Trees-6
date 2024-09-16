// Time Complexity: O(n)
// Space Complexity: O(n)
// using Recursion
public class RangeSumBST {
    int result, low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return result;
        
        this.low = low;
        this.high = high;
        
        dfs(root);
        
        return result;
    }
    
    
    // Can use any traversal (pre, post, inorder)
    // using inorder traversal
    // without BST optimization
    private void dfs(TreeNode root)
    {
        if(root == null)
            return;
        
        dfs(root.left);
        
        if(root.val >= low && root.val <= high)
        {
            result += root.val;
        }
        
        dfs(root.right);
    }

     // with BST optimization
    private void dfs(TreeNode root)
    {
        if(root == null)
            return;
        
        if(root.val >= low)
            dfs(root.left);
        
        if(root.val >= low && root.val <= high)
        {
            result += root.val;
        }
        
        if(root.val <= high)
            dfs(root.right);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// using Controlled Stack ie. Iterative recursion
public class RangeSumBST {

    // with optimization
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        if(root == null)
            return result;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        // can use any traversal, inorder, preorder, postorder
        while(!s.isEmpty())
        {
            root = s.pop();

            if(root.val >= low && root.val <= high)
                result += root.val;

            if(root.left != null && root.val >= low)
                s.push(root.left);

            if(root.right != null && root.val <= high)
                s.push(root.right);
        }
        
        return result;
    }
    
    // without optimization
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        if(root == null)
            return result;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty())
        {
            root = s.pop();

            if(root.val >= low && root.val <= high)
                result += root.val;

            if(root.left != null)
                s.push(root.left);

            if(root.right != null)
                s.push(root.right);
        }
        
        return result;
    }
    
}
