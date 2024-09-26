package trees6;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
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

	// Time Complexity : O(n) 
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null)
			return "";

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				sb.append(curr.val);
				q.offer(curr.left);
				q.offer(curr.right);
			}
			else
				sb.append("null");
			sb.append(",");
		}

		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0)
			return null;

		String[] nodes = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		int idx = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty() && idx < nodes.length) {
			TreeNode curr = q.poll();
			if(!nodes[idx].equals("null")) {
				curr.left = new TreeNode(Integer.parseInt(nodes[idx]));
				q.offer(curr.left);
			}
			idx++;
			if(!nodes[idx].equals("null")) {
				curr.right = new TreeNode(Integer.parseInt(nodes[idx]));
				q.offer(curr.right);
			}
			idx++;
		}

		return root;
	}
}
