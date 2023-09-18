public class SumRanges {
    //Time complexity: O(N)
    //Space complexity: O(1)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        int sum = 0;
        if(root.val >=low  && root.val <= high){
            sum+=root.val;
        }

        return rangeSumBST(root.left, low, high)+rangeSumBST(root.right, low, high)+sum;

    }
}
