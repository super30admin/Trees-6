// Time Complexity : O(N), iterating over all the nodes
// Space Complexity : O(N), queue to store nodes, string builder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//We use BFS to traverse the nodes. We save the null nodes while serializing.
//We use exactly same approach while deserializing.

//BFS approach
public class Codec {
//T: O(N)
    //S: O(N)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            //null check
            if(curr == null){
                sb.append("null,");
                continue;
            }else{
                sb.append(curr.val + ",");
            }
            
            //we don't need to check for null as we need to put them into queue
            q.offer(curr.left);
            q.offer(curr.right);            
        }
        
        System.out.println(sb.toString());
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.equals("")) return null;
        
        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int cursor = 1;
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            if(!tokens[cursor].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(tokens[cursor]));
                q.offer(curr.left);
            }
            
            cursor++;
            
            if(!tokens[cursor].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(tokens[cursor]));
                q.offer(curr.right);
            }
            
            cursor++;            
        }
        
        return root;
    }
}


//====================================================================================================================================================

//DFS

// Time Complexity : O(N), iterating over all the nodes
// Space Complexity : O(N), recursive call stack, string builder

//Use simple preorder for both serialize and deserialize

public class Codec {
 
    private void buildString(TreeNode root, StringBuilder sb){
        
        if(root == null){
            sb.append("null,");
        }else{
            sb.append(root.val + ",");
            buildString(root.left, sb);
            buildString(root.right, sb); 
        }        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        
        buildString(root, sb);

        return sb.toString();
    }
    
    public TreeNode deserializeString(List<String> nodeTokens){
        
        String first = nodeTokens.remove(0);
        
        if(first.equals("null")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserializeString(nodeTokens);
        root.right = deserializeString(nodeTokens);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        //initialize a list
        List<String> nodeTokens = new ArrayList<>();
        
        String[] tokens = data.split(",");
        
        for(String token: tokens){
          nodeTokens.add(token);  
        }
        
        
        //System.out.println(nodeTokens);
         return deserializeString(nodeTokens);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));