// Approach: BFS (slower runtime than DFS)
// Time: O(n)
// Space: O(n)

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_BFS {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("#");
            } else {
                sb.append(curr.val);
            }
            sb.append(",");
            if (curr != null) {
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // null
        if (data == null || data.length() == 0) return null;
        String[] strArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty() && i < strArr.length) {
            TreeNode curr = q.poll();
            // left child
            if (strArr[i].equals("#")) {
                curr.left = null;
            } else {
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;

            // right child
            if (strArr[i].equals("#")) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}