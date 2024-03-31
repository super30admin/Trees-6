public class SerializeAndDeserializeTree {
    // Encodes a tree to a single string.
    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("#");
                sb.append(",");
            } else {
                sb.append(curr.val);
                sb.append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return sb.toString();
    }

    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < arr.length;) {
            TreeNode curr = queue.poll();
            String left = arr[i];
            String right = arr[i + 1];
            if (left.equals("#")) {
                curr.left = null;
            } else {
                TreeNode leftN = new TreeNode(Integer.valueOf(left));
                queue.add(leftN);
                curr.left = leftN;
            }
            i++;
            if (right.equals("#")) {
                curr.right = null;
            } else {
                TreeNode rightN = new TreeNode(Integer.valueOf(right));
                queue.add(rightN);
                curr.right = rightN;
            }
            i++;
        }
        return root;
    }
}
