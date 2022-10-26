import java.util.*;
class rangeSumBST {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(250);
        root.left = new TreeNode(100);
        root.right = new TreeNode(300);
        System.out.println(rangeSumBST(root,200, 300));
    }
    static int result = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return result;
    }
    public static void dfs(TreeNode root, int low, int high) {
        if(root == null) return;

        if(root.val >= low && root.val <= high)
            result += root.val;
        if(root.val >= low)
            dfs(root.left,low,high);     
        if(root.val <= high)    
            dfs(root.right,low,high);
    }
}

class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }
}