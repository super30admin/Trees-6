// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(null != temp) {
                sb.append(temp.val);
                q.add(temp.left);
                q.add(temp.right);
            }
            else
                sb.append("null");
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(data == null || data.length() == 0) return null;
        int rootVal = Integer.parseInt(arr[0]); int left; int right;
        TreeNode root = new TreeNode(rootVal);
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(!arr[idx].equals("null")) {
                left = Integer.parseInt(arr[idx]);
                temp.left = new TreeNode(left);
                q.add(temp.left);
            } else {
                temp.left = null;
            }
            idx++;
            if(!arr[idx].equals("null")) {
                right = Integer.parseInt(arr[idx]);
                temp.right = new TreeNode(right);
                q.add(temp.right);
            } else {
                temp.right = null;
            }
            idx++;
        }
        return root;
    }
}