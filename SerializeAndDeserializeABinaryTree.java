

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
        String retStr = "";
        if(root == null) return retStr;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            
            if(front == null){
                retStr += "NULL,";
            } else{
                retStr += Integer.toString(front.val)+ ",";
                queue.add(front.left);
                queue.add(front.right);
            }
            // we need NUll as well so no need of for loop
          
        }
        while(!Character.isDigit(retStr.charAt(retStr.length()-1))){
            retStr = retStr.substring(0,retStr.length()-1);
        }
        
        return retStr;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
     if(data == "") return null;
       
    String[] processed = data.split(",");
    int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(processed[index]));
        index+= 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty() && index < processed.length){
            TreeNode front = queue.poll();
            
            if(index < processed.length && processed[index].compareTo("NULL") !=0){
                front.left = new TreeNode(Integer.parseInt(processed[index]));
                queue.add(front.left);
            }
            index+=1;
            
            if(index < processed.length && processed[index].compareTo("NULL") !=0){
                front.right = new TreeNode(Integer.parseInt(processed[index]));
                queue.add(front.right);
            }
            index+=1;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
