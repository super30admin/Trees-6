import java.util.*;

public class SerializeandDeserialize {

    // Serializing - Convert object to string
    // Normal BFS but include null values as well.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                sb.append(node == null ? "null" : node.val);
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    // Serializing - Build string to TreeNode
    // Normal BFS - have a pointer in the spllited array.
    // The current element from the queue is the parent and first ith position would
    // be the left child and i+1 would be rith child
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] splittedArray = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(splittedArray[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        i++;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (!splittedArray[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(splittedArray[i]));
                queue.add(current.left);
            }

            i++;

            if (!splittedArray[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(splittedArray[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeandDeserialize serializeandDeserialize = new SerializeandDeserialize();
        TreeNode result = serializeandDeserialize
                .deserialize(serializeandDeserialize.serialize(new TreeNode().getSample()));
    }
}