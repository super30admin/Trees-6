// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        //bfs
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.val == 1001){
                sb.append("#,");
            } else{
                sb.append(node.val);
                sb.append(",");
                if(node.left == null) q.add(new TreeNode(1001));
                else q.add(node.left);
                if(node.right == null) q.add(new TreeNode(1001));
                else q.add(node.right);
            }
        }
        sb.setLength(sb.length() -1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int p = 1;
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(!arr[p].equals("#")){
                node.left = new TreeNode(Integer.parseInt(arr[p]));
                p++;
                q.add(node.left);
            }else{
                p++;
            }

            if(!arr[p].equals("#")){
                node.right = new TreeNode(Integer.parseInt(arr[p]));
                p++;
                q.add(node.right);
            }else{
                p++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));