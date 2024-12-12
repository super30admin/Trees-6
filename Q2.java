/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void serializeHelepr(TreeNode root, StringBuilder path) {
        // base
        if (root == null) {
            path.append('#');
            path.append(',');

            return;
        }

        path.append(root.val);
        path.append(',');
        serializeHelepr(root.left, path);
        serializeHelepr(root.right, path);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder path = new StringBuilder();
        serializeHelepr(root, path);

        return path.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        return deserializeHelepr(arr);
    }

    int index = 0;

    private TreeNode deserializeHelepr(String[] arr) {
        // base
        if (arr[index].equals("#")) {
            index++;
            return null;

        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = deserializeHelepr(arr);
        root.right = deserializeHelepr(arr);
        return root;

    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
