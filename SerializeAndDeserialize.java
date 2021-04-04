/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS for serialize and deserialize
public class Codec {
    // Encodes a tree to a single string.
    //TC: O(N) : N nodes
    //SC: O(N) : Queue size
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if ( root == null )
            return sb.toString();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if (curr == null){
                sb.append("null").append(',');
                continue;
            }
            sb.append(curr.val).append(',');
            q.offer(curr.left);
            q.offer(curr.right);          
        }
        System.out.println(sb.toString());
        int i = sb.length() - 1;
       
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    //TC: O(N) : N -> length of string data
    //SC: O(N) : Queue size
    public TreeNode deserialize(String data) {
         if ( data == null || data.length() == 0)
               return null;
         String[] splitDataArray = data.split(",");
         Queue<TreeNode> q = new LinkedList();
         TreeNode root = new TreeNode(Integer.parseInt(splitDataArray[0]));
         q.add(root);
         int i = 0;
         while(!q.isEmpty() && i < splitDataArray.length){
             TreeNode curr = q.poll();
             i++;
             if (  i < splitDataArray.length && !splitDataArray[i].equals("null")){
                 curr.left = new TreeNode(Integer.parseInt(splitDataArray[i]));
                 q.offer(curr.left);
             }
             i++;
             if (i < splitDataArray.length && !splitDataArray[i].equals("null")){
                 curr.right = new TreeNode(Integer.parseInt(splitDataArray[i]));
                 q.offer(curr.right);
             }
         }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
