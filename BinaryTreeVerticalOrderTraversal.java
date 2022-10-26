// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(n) where n = number of nodes
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//314. Binary Tree Vertical Order Traversal (Medium) - https://leetcode.com/problems/binary-tree-vertical-order-traversal/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(n) where n = number of nodes
class Solution {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> height = new LinkedList<>();
		queue.add(root);
		height.add(0);

		int min = 0, max = 0;

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			int h = height.poll();

			if (!map.containsKey(h)) {
				map.put(h, new ArrayList<>());
			}
			map.get(h).add(curr.val);

			if (curr.left != null) {
				queue.add(curr.left);
				height.add(h - 1);
				min = Math.min(min, h - 1);
			}

			if (curr.right != null) {
				queue.add(curr.right);
				height.add(h + 1);
				max = Math.max(max, h + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}

		return result;
	}
}