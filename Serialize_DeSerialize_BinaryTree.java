//TC: O(n)
//SC: O(n) [Queue+Recursive Stack]
/*Approach: I first performed a preorder traversal on the given array and inserted into the queue. Then as I poll out each kement in the queue I started constructing a Binary Tree again using a preorder traversal*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = serializeHelper(root,sb);
        String res = sb.toString();
        return res;
    }
    
    private StringBuilder serializeHelper(TreeNode root, StringBuilder sb){
        if(root==null) return sb.append("null");
        
        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        sb.append(",");
        serializeHelper(root.right,sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        //int[] arr = Arrays.asList();
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
        }
        return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
        
    }
}

