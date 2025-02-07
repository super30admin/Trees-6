//297. Serialize and Deserialize Binary Tree - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//Time Complexity:
//Space Complexity:

public class Codec {
    public String serialize(TreeNode root) {
        //base case
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        int idx = 0;
        String[] splitArray = data.split(","); // Split serialized string

        TreeNode root = new TreeNode(Integer.parseInt(splitArray[idx]));
        idx++;

        Queue<TreeNode> q = new LinkedList<>(); //to know left, right babies
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!splitArray[idx].equals("#")) { // If left child exists
                curr.left =  new TreeNode(Integer.parseInt(splitArray[idx]));
                q.add(curr.left); // Add left child to queue
            } else {
                curr.left = null;
            }
            idx++;
            if(!splitArray[idx].equals("#")) { // If right child exists
                curr.right = new TreeNode(Integer.parseInt(splitArray[idx]));
                q.add(curr.right); // Add left child to queue
            } else {
                curr.right = null;
            }
            idx++;
        }
        return root; // Return reconstructed tree
    }
}
