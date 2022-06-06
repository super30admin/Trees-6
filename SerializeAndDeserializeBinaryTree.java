//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

public class SerializeAndDeserializeBinaryTree {
    final String X = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    String[] arr;
    int index=0;
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return dfs();
    }
    private TreeNode dfs(){
        if(arr[index].equals("X")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = dfs();
        root.right = dfs();
        return root;
    }
}
