//Time Complexity: O(N)
//Space Complexity: O(N)
//Print the tree in pre-order traversal and use "null" to denote null node and split node with ",". We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store the pre-order traversal and since we have "null" as null node, we know exactly how to where to end building subtress.
public class Codec {

    private void buildString(TreeNode node, StringBuilder sb)
    {
        if(node == null)
        {
            sb.append("null").append(",");
        }
        else
        {
            sb.append(node.val).append(",");
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes)
    {
        String val = nodes.remove();
        if(val.equals("null"))
            return null;
        else
        {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}