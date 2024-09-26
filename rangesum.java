# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No








class Solution {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        return solve(root, L, R);
    }


    public int solve(TreeNode root, int L, int R){
        if(root == null)
            return 0;


        solve(root.left, L, R);
        if(root.val >= L && root.val <= R)
            sum += root.val;


        solve(root.right, L, R);

        return sum;
    }


}