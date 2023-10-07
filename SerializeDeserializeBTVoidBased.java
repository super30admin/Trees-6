// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class SerializeDeserializeBTVoidBased {
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
        sb.append(root.val);
        sb.append(",");

        helperSerialize(root.left);

        helperSerialize(root.right);


    }
    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] splitArr = data.split(",");
        idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[0]));

        helperDeserialize(splitArr, root);
        return root;
    }

    private void helperDeserialize(String[] splitArr, TreeNode curr){

        if(idx == splitArr.length) return ;

        if(splitArr[idx].equals("#")){
            idx++;
            return ;
        }
        idx++;
        if(!splitArr[idx].equals("#"))
        {
            curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
            helperDeserialize(splitArr,curr.left);
        }

        idx++;
        if(!splitArr[idx].equals("#"))
        {
            curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
            helperDeserialize(splitArr,curr.right);
        }

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

