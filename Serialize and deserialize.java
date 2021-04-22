//time complexity-O(n)
//Space complexity-O(width of tree+string)
//Ran on leetcode-Yes
//Solution with comments-
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
        
        preorder(root,sb);
        
        String ans= sb.deleteCharAt(sb.length()-1).toString();
        return ans;
    }
    public void preorder(TreeNode node , StringBuilder sb){//traversign tree in preorder
        if(node==null){
            sb.append("null,");//if any children is not present we will add null
            return;
        }
        sb.append(node.val);
        sb.append(",");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");//splitting on comma the string obtained from serialization
        List<String> t= new LinkedList<>(Arrays.asList(temp));
        
        return decode(t);
    }
    public TreeNode decode(List<String> temp){
        if(temp.get(0).equals("null")){
           temp.remove(0);
            return null;
        }
        TreeNode node= new TreeNode(Integer.parseInt(temp.remove(0)));//removeing the first element once it's node is created
       
        node.left=decode(temp);
        node.right=decode(temp);
         return node;
       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));