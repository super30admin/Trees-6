// Approach: DFS (faster runtime than BFS)
// Time: O(n)
// Space: O(n)

public class SerializeAndDeserializeBinaryTree_DFS {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        this.sb = new StringBuilder();
        serializeHelper(root);
        return sb.toString();
    }
    private void serializeHelper(TreeNode root) {
        if (root == null) {
            sb.append('#');
            sb.append(',');
            return;
        }

        sb.append(root.val);
        sb.append(',');
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strArr = data.split(",");
        return deserializeHelper(strArr);
    }
    int idx;
    private TreeNode deserializeHelper(String[] strArr) {
        // base
        if (idx == strArr.length) return null;
        // logic
        if (strArr[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strArr[idx]));
        idx++;
        root.left = deserializeHelper(strArr);
        root.right = deserializeHelper(strArr);
        return root;
    }
}