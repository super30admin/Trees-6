//Time Complexity-O(V+E)
//Space Complexity-O(n)

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

    public String serializeRecursion(TreeNode root,String str)
    {
        //preorder
        if(root==null)
        {
            str+="null,";
            return str;
        }
        //root
        str+=str.valueOf(root.val)+",";
        //left
        str=serializeRecursion(root.left,str);
        //right
        str=serializeRecursion(root.right,str);
        return str;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeRecursion(root,"");
    }
    public TreeNode deserializeRecursion(List<String>data)
    {
        if(data.get(0).equals("null"))
        {
            data.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left=deserializeRecursion(data);
        root.right=deserializeRecursion(data);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        List<String>list=new LinkedList(Arrays.asList(arr));
        return deserializeRecursion(list);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));