// Time Complexity:  Serialize and Desirialize O(n) as each node is constructed and deconstructed once
// Space complexity: O(n) Queue storage space

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBFS {
    public String serialize(TreeNode root){
        if( root == null) return "X";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);;

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if( curr == null) {
                sb.append("X,");
                continue;
            }
            sb.append(curr.val).append(",");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return sb.toString();

    }

    public TreeNode deserialize( String data){

        if(data.equals("X")) return null;
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int i = 1;
        while( ! queue.isEmpty()){
            TreeNode curr = queue.poll();

            if( !values[i].equals("X")){
                curr.left = new TreeNode (Integer.parseInt(values[i]));
                queue.add( curr.left);
            }
            i++;
            if( !values[i].equals("X")){
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;

    }

    public static void main(String[] args) {
        SerializeAndDeserializeBFS codec = new SerializeAndDeserializeBFS();

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
