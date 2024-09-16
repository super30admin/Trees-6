/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
mehtod 1:

used dfs approach here to solve problem
TC: O(N)

method 2: BFS usinf queue
TC:O(n)

*/
public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
        
//         return serial(root,"");
        
//     }
//     public String serial(TreeNode node, String str){
//         if(node == null){
//             str += "null,";
            
//         }else{
//             str += String.valueOf(node.val)+",";
//             str = serial(node.left,str);
//             str = serial(node.right,str);
//         }
//         return str;
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String[]array = data.split(",");
//         List<String> datalist = new LinkedList<String>(Arrays.asList(array));
//         return deserial(datalist);
//     }
    
//     public TreeNode deserial(List<String> datalist){
//         if(datalist.get(0).equals("null")){
//             datalist.remove(0);
//             return null;
//         }
        
//         TreeNode root = new TreeNode(Integer.parseInt(datalist.remove(0)));
//         root.left = deserial(datalist);
//         root.right= deserial(datalist);
        
        
//         return root;
//     }
    
    //method 2: 
    
    public String serialize(TreeNode root){
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != null){
                sb.append(curr.val);sb.append(",");
                queue.add(curr.left);
                queue.add(curr.right);
                
            }else{
                sb.append("null");
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
     public TreeNode deserialize(String data){
         
         if(data == null || data.length() == 0)return null;
         
         String[]array = data.split(",");
         Queue<TreeNode> queue = new LinkedList<>();
         
         int i = 0;
         TreeNode root = new TreeNode(Integer.parseInt(array[i]));
         i++;
         queue.add(root);
         while(!queue.isEmpty()){
             TreeNode node = queue.poll();
             
             if(!array[i].equals("null")){
                 node.left = new TreeNode(Integer.parseInt(array[i]));
                 queue.add(node.left);
             }
             i++;
             if(!array[i].equals("null")){
                 node.right = new TreeNode(Integer.parseInt(array[i]));
                 queue.add(node.right);
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