//TC: O(n)
//SC: O(n)
//running on leetcode: yes
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr != null) {
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
            else {
                sb.append("null");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        //split the given data into array of strings separated by ,
        String[] strArray = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        int i = 1;
        q.add(root);
        while(!q.isEmpty() && i < strArray.length) {
            TreeNode curr = q.poll();
            if(!strArray[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(strArray[i]));
                q.add(curr.left);
            }
            i++;
            if(!strArray[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(strArray[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
