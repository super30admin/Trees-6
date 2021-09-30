// Time Complexity : O(n), n -> Number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		sb.append(root.val);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node.left != null) {
				queue.add(node.left);
				sb.append(",").append(node.left.val);
			} else {
				sb.append(",").append("null");
			}

			if (node.right != null) {
				queue.add(node.right);
				sb.append(",").append(node.right.val);
			} else {
				sb.append(",").append("null");
			}
		}

		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.equals("")) {
			return null;
		}

		String[] strArr = data.split(",");
		Queue<TreeNode> queue = new LinkedList<>();

		TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
		int n = strArr.length;
		int i = 1;

		queue.add(root);

		while (!queue.isEmpty() && i < n) {
			TreeNode node = queue.poll();

			if (!strArr[i].equals("null")) {
				node.left = new TreeNode(Integer.valueOf(strArr[i]));
				queue.add(node.left);
			}

			i++;

			if (i == n) {
				break;
			}

			if (!strArr[i].equals("null")) {
				node.right = new TreeNode(Integer.valueOf(strArr[i]));
				queue.add(node.right);
			}
			i++;
		}

		return root;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String serializedTree = obj.serialize(root);

		System.out.println("Tree has been serialized -> " + serializedTree);
		TreeNode deserializedTree = obj.deserialize(serializedTree);
		System.out.println("Tree has been deserialized.");
	}

}
