package s30.trees.trees6;

import s30.trees.TreeNode;


//algo: use BST property and avoid going to every node
//TC: O(n)
//SC: O(h)
public class RangeSumBST {


    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {

        res =0;

        rangeSumBSTRec(root, low, high);

        return res;


    }

    private void rangeSumBSTRec(TreeNode root, int low, int high){

        //base
        if(root == null) return;


        if(root.val > high)
            rangeSumBSTRec(root.left, low, high);

        else if(root.val < low)
            rangeSumBSTRec(root.right, low, high);

            //recurse
        else if(root.val >= low && root.val <= high) {
            res += root.val;

            rangeSumBSTRec(root.left, low, high);
            rangeSumBSTRec(root.right, low, high);
        }


    }
    public static void main(String[] args) {

    }
}
