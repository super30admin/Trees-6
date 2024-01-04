// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class Codec {
    int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        serializeHelper(root,sb);
        System.out.println(sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode root, StringBuilder sb){
        //base

        //logic
        if(root.left!=null){
            sb.append(",");
            sb.append(root.left.val);
            serializeHelper(root.left,sb);
        }
        else{
            sb.append(",");
            sb.append("#");
        }
        if(root.right!=null){
            sb.append(",");
            sb.append(root.right.val);
            serializeHelper(root.right,sb);
        }
        else{
            sb.append(",");
            sb.append("#");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] strArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        this.idx = 1;
        deserializeHelper(root,strArr);
        return root;
    }
    private void deserializeHelper(TreeNode root, String[] strArr){
        if(!strArr[idx].equals("#")){
            root.left = new TreeNode(Integer.parseInt(strArr[idx]));
            idx++;
            deserializeHelper(root.left,strArr);
        }
        else{
            idx++;
        }
        if(!strArr[idx].equals("#")){
            root.right = new TreeNode(Integer.parseInt(strArr[idx]));
            idx++;
            deserializeHelper(root.right,strArr);
        }
        else{
            idx++;
        }
    }
}