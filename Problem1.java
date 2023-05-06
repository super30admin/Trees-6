/*
Range SumBST
approach: we can do traverse through all nodes or use bst property
time: O(n)
space: O(h)
 */
public class Problem1 {
/*    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int curr = 0;
        if(root.val>=low && root.val<=high) {
            curr = root.val;
        }
        int left = rangeSumBST(root.left,  low,  high);
        int right = rangeSumBST(root.right,  low,  high);
        return left+right+curr;
    }*/

//    using BST property
    /*
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int curr = 0;
        int left  = 0, right = 0;
        if(root.val>=low && root.val<=high) {
            curr = root.val;
            System.out.println("root "+root.val);
        }

        if(root.left!=null && root.val>=low) left = rangeSumBST(root.left,  low,  high);
        if(root.right!=null && root.val<=high) right = rangeSumBST(root.right,  low,  high);
        return left+right+curr;
    }*/
}
