import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * BFS approach by tracking the distance from root
 */

public class BinaryTreeVerticalOrder {
    public class TreeNode {
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();

        q.add(root);
        dist.add(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int distance = dist.poll();
            min = Math.min(min, distance);
            max = Math.max(max, distance);

            List<Integer> item = new ArrayList<>();
            if (map.containsKey(distance)) {
                item = map.get(distance);
            }
            item.add(curr.val);
            map.put(distance, item);
            if (curr.left != null) {
                q.add(curr.left);
                dist.add(distance - 1);
            }

            if (curr.right != null) {
                q.add(curr.right);
                dist.add(distance + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
    public static void main(String[] args) {
        // Your code here
    }
}