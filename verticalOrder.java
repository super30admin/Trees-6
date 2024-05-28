/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * class Solution {
 * public List<List<Integer>> verticalOrder(TreeNode root) {
 * //Tc: O(n) Sc: O(n)
 * if (root == null)
 * return new ArrayList<>();
 * HashMap<Integer, List<Integer>> map = new HashMap<>();
 * Queue<TreeNode> q = new LinkedList<>();
 * Queue<Integer> cols = new LinkedList<>();
 * q.add(root);
 * cols.add(0);
 * 
 * int min = 0;
 * int max = 0;
 * 
 * while (!q.isEmpty()) {
 * TreeNode cur = q.poll();
 * int curCol = cols.poll();
 * if (!map.containsKey(curCol)) {
 * map.put(curCol, new ArrayList<>());
 * }
 * 
 * map.get(curCol).add(cur.val);
 * if (cur.left != null) {
 * q.add(cur.left);
 * cols.add(curCol - 1);
 * min = Math.min(min, curCol - 1);
 * }
 * 
 * if (cur.right != null) {
 * q.add(cur.right);
 * cols.add(curCol + 1);
 * max = Math.max(max, curCol + 1);
 * }
 * }
 * List<List<Integer>> res = new ArrayList<>();
 * for (int i = min; i <= max; i++) {
 * res.add(map.get(i));
 * }
 * return res;
 * }
 * }
 * 
 */