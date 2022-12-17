// TC: O(N)
// SC : O(3N) == O(N)
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
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(root);
        cols.add(0);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);

            if(curr.left != null) {
                q.add(curr.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }

            if(curr.right != null) {
                q.add(curr.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;

    }
}