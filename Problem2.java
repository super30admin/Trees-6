/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //TC:O(n)
 //SC: O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root == null) return "";
         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append('#');
            }else{
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            sb.append(',');
         }
         return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)return null;
        String [] strArr = data.split(",");
        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        idx++;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            //left node
            if(!strArr[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(strArr[idx]));
                q.add(curr.left);
            }
            idx++;
            //right node
            if(!strArr[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(strArr[idx]));
                q.add(curr.right);
            }
            idx++;

        }
        return root;        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
