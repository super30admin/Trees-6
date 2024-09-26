/*
Problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// TC: O(n)
// SC: O(n)
*/

// BFS Approach
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
        if (root == null)
            return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        
        queue.offer(root);
        columns.offer(0);
        
        // We don't need queue size and to run a for loop over the size value
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curCol = columns.poll();
            
            if (!map.containsKey(curCol)) {
                map.put(curCol, new ArrayList<>());
            }
            map.get(curCol).add(curNode.val);
            
            if (curNode.left != null) {
                queue.add(curNode.left);
                columns.add(curCol - 1);
            }
            
            if (curNode.right != null) {
                queue.add(curNode.right);
                columns.add(curCol + 1);
            }
            
            min = Math.min(min, curCol);
            max = Math.max(max, curCol);
        }
        
        for (int i = min; i <= max; ++i) {
            result.add(map.get(i));
        }
        
        return result;
    }
}