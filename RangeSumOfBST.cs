using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class RangeSumOfBST
    {
        /*
         * T.C: O(n) where n is no of nodes in the tree
         * S.C: O(h) where h is hight of tree
         */
        int sum;
        public int RangeSumBST(TreeNode root, int low, int high)
        {
            if (root == null) return 0;

            dfs(root, low, high);

            return sum;
        }

        public void dfs(TreeNode root, int low, int high)
        {
            //base
            if (root == null) return;

            //logic

            if (root.val > low)
            {
                dfs(root.left, low, high);
            }

            if (root.val >= low && root.val <= high)
            {
                sum += root.val;
            }


            if (root.val < high)
            {
                dfs(root.right, low, high);
            }

        }
    }
}
