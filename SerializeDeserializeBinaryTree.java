/**
 * Implements serialization and deserialization of a binary tree using BFS.
 * Encodes the tree as a comma-separated string with '#' representing null nodes.
 * Decodes the string back to the original binary tree structure.
 */
// Time Complexity: O(N), where N is the number of nodes in the tree
// Space Complexity: O(N), for the queue and string builder used in processing

public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                sb.append("#").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;

        String[] splitArr = data.split(",");
        int idx = 0;

        TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
        idx++;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (!splitArr[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            } else {
                curr.left = null;
            }
            idx++;
            if (!splitArr[idx].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.right);
            } else {
                curr.right = null;
            }
            idx++;
        }
        return root;
}
}
