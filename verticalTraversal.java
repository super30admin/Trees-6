// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We do a BFS traversal since we need to return from top to bottom in a colomn
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // first entry starts from root and count starts from 0
        q.add(root);
        count.add(0);

        // BFS
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int col = count.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);

            if (curr.left != null) {
                q.add(curr.left);
                count.add(col-1);
            }
            if (curr.right != null) {
                q.add(curr.right);
                count.add(col+1);
            }

            max = Math.max(max, col);
            min = Math.min(min, col);
        }

        for (int i=min; i<=max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}