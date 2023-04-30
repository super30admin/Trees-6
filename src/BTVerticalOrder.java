import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply BFS. For each left node, put level as current level -1 and
 * for each right node, put level as current level + 1. Put all these
 * node values in the respective map keys. Also maintain min and max
 * of the root values traversed. Iterate over the min to max to get
 * the list of values and return that list of lists.
 *
 */
class Solution {
    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        int minCol = 0, maxCol = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            if(!map.containsKey(p.level)) {
                map.put(p.level, new ArrayList<>());
            }
            map.get(p.level).add(p.node.val);
            minCol = Math.min(minCol, p.level);
            maxCol = Math.max(maxCol, p.level);
            if(p.node.left != null)
                queue.offer(new Pair(p.node.left, p.level - 1));
            if(p.node.right != null)
                queue.offer(new Pair(p.node.right, p.level + 1));
        }
        for(int i=minCol;i<=maxCol;i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
