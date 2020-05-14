// Time Complexity :O(N)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


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
// //BFS
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         if(root == null) return "";
//        StringBuilder sb=new StringBuilder();
//         if(root == null) return "";
//         Queue<TreeNode> q=new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             TreeNode current=q.poll();
//             if(current ==null){
//                 sb.append("null,");
//                 continue;
//             }
//             else{
//             sb.append(current.val+",");  
//             }
//            q.add(current.left);
//            q.add(current.right);
//         }
//         return sb.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         if(data.length()==0) return null;
//         Queue<TreeNode> q=new LinkedList<>();
//         String[] tokens = data.split(",");
       
//         TreeNode root=new TreeNode(Integer.parseInt(tokens[0]));
//          q.add(root);
//         int cursor=1;
//         while(!q.isEmpty()){
//            TreeNode current=q.poll();
//             if(!tokens[cursor].equals("null")){
//             current.left = new TreeNode(Integer.parseInt(tokens[cursor]));
//                 q.add(current.left);
//             }
//             cursor++;
//           if(!tokens[cursor].equals("null")){
//             current.right = new TreeNode(Integer.parseInt(tokens[cursor]));
//                q.add(current.right);
//             }
//             cursor++;
//         }
//         return root;
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// DFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if(root ==null) return "";
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
 }
    public void buildString(TreeNode root,StringBuilder sb){
        if(root == null){
        sb.append("null,");
        }
        else{
           sb.append(root.val+",");  
        buildString(root.left,sb);
        buildString(root.right,sb); 
        }  
    }
   int cursor=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.length()==0) return null;
        String[] tokens= data.split(",");
       return buildString(tokens);
        
    }
    public TreeNode buildString(String[] tokens){
        TreeNode root;
       if(cursor >= tokens.length){
           return null;
       }
       
       if(tokens[cursor].equals("null")){
              cursor++;
            root = null;
           return root; 
          
        }
        else{
           
        root=new TreeNode(Integer.parseInt(tokens[cursor]));
             cursor++;
       root.left = buildString(tokens);
       root. right = buildString(tokens);   
        }
        return root;
    }
}











