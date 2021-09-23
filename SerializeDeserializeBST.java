// Time Complexity : O(n)
// Space Complexity : O(n)

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
        StringBuilder sb = new StringBuilder();
        if(root  == null)
            return sb.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur != null){
                q.add(cur.left);
                q.add(cur.right);
                sb.append(cur.val+",");
            }
            else
                 sb.append("null,");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        
        String[] dataArr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            i++;
            if(i<dataArr.length && !dataArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(curr.left);
            }
            i++;
            if(i<dataArr.length && !dataArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(curr.right);

            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));