/**
Time: O(N)
Space: O(N) for deque and O(H) recursive stack space
Approach:
=======
Serialize:

1. Fill in the nodes' values in stringbuilder, with splitter as separator
2. When a node has no left/right child, represent null with a string
3. Iterate preorder, append to sb and return the serialized string

Deserialize:

1. Add all node values to deque
2. Check if node's value is same as null string and if so, return null
3. If not, create tree node and recursively call build tree method to add left and right nodes
4. Return the node as result
 */
public class Codec {
    public static final String splitter = ",";
    public static final String nilVal = "X"; 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return ""; 
        
        StringBuilder sb = new StringBuilder(); 
        serializeHelper(root, sb); 
        return sb.toString(); 
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(nilVal); 
            sb.append(splitter); 
            return; 
        }
        sb.append(root.val);
        sb.append(splitter); 
        serializeHelper(root.left, sb); 
        serializeHelper(root.right, sb); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        // Add all node values to queue
        Deque<String> q = new LinkedList<>(); 
        q.addAll(Arrays.asList(data.split(splitter))); 
        return deserializeHelper(q); 
    }
    
    private TreeNode deserializeHelper(Deque<String> dq) {
        String val = dq.remove(); 
        if(val.equals(nilVal)) return null; 
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deserializeHelper(dq); 
            node.right = deserializeHelper(dq); 
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));