/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
public class Codec {

    public String serialize(TreeNode root) {
        
        if(root == null) return "null";
        
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        
        sb.append(" ");
        
        sb.append(serialize(root.left));
        sb.append(" ");
        sb.append(serialize(root.right));
        return sb.toString();
        
        
    }
    
    
    int index = 0;
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(" ");
        if(arr.length == 0) return null;
        
        return helper(arr);
    }
    
    
    TreeNode helper(String[] arr){
        if(index == arr.length) return null;
        
        String s = arr[index++];
        
        if(s.equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(s));
        
        root.left = helper(arr);
        root.right = helper(arr);
        
        return root;
    }
}