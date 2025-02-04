// Time Complexity:  Serialize and Desirialize O(n) as each node is constructed and deconstructed once
// Space complexity: O(n) Recursive stack space
import java.util.*;
public class SerializeAndDesrializeBT  {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X,");
            return;
        }
        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Deserializes a string back to a tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeDFS(nodes);
    }

    private TreeNode deserializeDFS(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("X")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeDFS(nodes);
        node.right = deserializeDFS(nodes);
        return node;
    }
    public static void main(String[] args) {
        SerializeAndDesrializeBT codec = new SerializeAndDesrializeBT();

        // Creating a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serializing the tree
        String serializedTree = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        // Deserializing the tree
        TreeNode deserializedRoot = codec.deserialize(serializedTree);
        System.out.println("Deserialization complete.");
    }
}
