// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We do a level order traversal to visit all nodes by tracking their width. We maintain a hashmap to keep
track of width levels from left to right and also have another queue to traverse using width. At last,
we iterate from the observed min to max values of the tree and add them to the result.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> widthQ = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.add(root);
        widthQ.add(0);
        int min = 0, max = 0;

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            int currWidth = widthQ.poll();
            map.putIfAbsent(currWidth, new ArrayList<>());
            map.get(currWidth).add(curr.val);

            if(curr.left != null) {
                q.add(curr.left);
                widthQ.add(currWidth - 1);
                min = Math.min(min, currWidth - 1);
            }

            if(curr.right != null) {
                q.add(curr.right);
                widthQ.add(currWidth + 1);
                max = Math.max(max, currWidth + 1);
            }
        }

        for(int i = min ; i <= max ; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}