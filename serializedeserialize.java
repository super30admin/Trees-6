//Time Complexity: Serialize - O(N) where N is the number of nodes in the tree
//                 Deserialize - O(N) where N is the number of Nodes to be present in the tree
//Space Complexity:O(N) for both the cases.
//Approach- Serialize-Using Recursion to traverse through the entire tree in a preorder fashion and append the nodes into a stringbuilder to serialize the tree.
//Deserialize- using queue to store the string version of the nodes, obtained by splitting them at the spliter and construct a tree.
//This code was executed successfully and got accepted in leetcode
public class Codec {

    // Encodes a tree to a single string.
    public static String spliter=",";
    public static String Null="N";
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(Null).append(spliter);
        }
        else{
            sb.append(root.val).append(spliter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<String> q){
        String val=q.poll();
        if(val.equals(Null)){
            return null;
        }
        else{
            TreeNode node=new TreeNode(Integer.valueOf(val));
            node.left=buildTree(q);
            node.right=buildTree(q);
            //System.out.println(node.val);
            return node;
        }
    }
}