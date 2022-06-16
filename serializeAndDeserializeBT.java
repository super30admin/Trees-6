//TC: O(n) for both serialize and deserialize function where n is length of no. of nodes in Binary tree 
//SC: O(n) 

//CODE:

//for serialization -> going level by level and adding node(including null) to the queue and then appending it to the stringBuilder  

//for deserializarion -> First split the data string and then iterate over the splitted array using idx pointer . Add the elements from array to the queue one by one and if the element is null do not add it to the queue , just increase the idx by 1 if it is null.

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();   //taking a stringBuilder
        Queue<TreeNode> q = new LinkedList<>();   
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr!= null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root =new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        int idx =1;
        while(!q.isEmpty() && idx<str.length){
            TreeNode curr = q.poll();
            if(!str[idx].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(str[idx]));
                q.add(curr.left);
            }
            idx++;
            if(!str[idx].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(str[idx]));
                q.add(curr.right);
            }
            idx++;
        }
        return root;
    }
}