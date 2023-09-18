import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {


    // Encodes a tree to a single string.
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public String serialize(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return null;
        queue.offer(root);
        StringBuilder treeString = new StringBuilder();
        treeString.append(root.val);
        treeString.append(" ");
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left == null){
                treeString.append("null");
            }
            else{
                treeString.append(current.left.val);
                queue.offer(current.left);
            }
            treeString.append(" ");
            if(current.right == null){
                treeString.append("null");
            }
            else{
                treeString.append(current.right.val);
                queue.offer(current.right);
            }
            treeString.append(" ");
        }

        return treeString.toString().trim();
    }

    // Decodes your encoded data to tree.
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(" ");
        TreeNode finalRoot = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(finalRoot);
        int childIndex = 1;
        while (!queue.isEmpty()) {
            TreeNode root = queue.poll();
            if (!nodes[childIndex].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(nodes[childIndex]));
                root.left = left;
                queue.offer(left);

            }
            if (!nodes[childIndex + 1].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(nodes[childIndex + 1]));
                root.right = right;
                queue.offer(right);
            }
            childIndex = childIndex + 2;
        }
        return finalRoot;
    }
}
