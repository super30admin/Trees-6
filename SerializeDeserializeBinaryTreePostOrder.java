// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class SerializeDeserializeBinaryTreePostOrder {
    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        if(root == null) return "";
        sb = new StringBuilder();
        helperSerialize(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void helperSerialize(TreeNode root){
        if(root == null){
            sb.append("#");
            sb.append(",");
            return;
        }

        helperSerialize(root.left);
        helperSerialize(root.right);
        sb.append(root.val);
        sb.append(",");

    }
    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] splitArr = data.split(",");
        idx = splitArr.length-1;
        return helperDeserialize(splitArr);
    }

    private TreeNode helperDeserialize(String[] splitArr){

        if(idx == 0) return null;

        if(splitArr[idx].equals("#")){
            idx--;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
        idx--;

        root.right = helperDeserialize(splitArr);
        root.left = helperDeserialize(splitArr);


        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

