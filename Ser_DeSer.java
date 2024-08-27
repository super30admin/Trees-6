// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                //sb.append(Integer.toString(curr.val));
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            else{
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        String [] strArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!strArr[i].equals("null")){
                TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i]));
                curr.left = newNode;
                q.add(curr.left);
            }
            i++;
            if(!strArr[i].equals("null")){
                TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i]));
                curr.right = newNode;
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));