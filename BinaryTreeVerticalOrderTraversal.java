// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        nodes.add(root);
        cols.add(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(null != curr.left) {
                nodes.add(curr.left);
                cols.add(col-1);
            }
            if(null != curr.right) {
                nodes.add(curr.right);
                cols.add(col+1);
            }
        }

        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}