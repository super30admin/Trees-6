
//TC - O(N)
//SC - O(N)
import java.util.*;

class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			if (curr != null) {
				sb.append(curr.val);
				sb.append(",");
				q.add(curr.left);
				q.add(curr.right);
			} else {
				sb.append("null");
				sb.append(",");
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == "")
			return null;
		String[] strArr = data.split(",");
		Queue<TreeNode> q = new LinkedList<>();
		int i = 0;
		TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
		q.add(root);
		i++;
		while (!q.isEmpty() && i < strArr.length) {
			TreeNode curr = q.poll();
			if (!strArr[i].equals("null")) {
				curr.left = new TreeNode(Integer.parseInt(strArr[i]));
				q.add(curr.left);
			}
			i++;
			if (!strArr[i].equals("null")) {
				curr.right = new TreeNode(Integer.parseInt(strArr[i]));
				q.add(curr.right);
			}
			i++;
		}
		return root;
	}
}
