// O(n) time complexity: visit n nodes
// O(n) space complexity: keep the entire tree

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
     public void  serialize(TreeNode root,StringBuilder sb) {
        if(root==null){
            sb.append("# ");
            return ;
        }
         sb.append(root.val+" ");
         serialize(root.left,sb);
         serialize(root.right,sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
     public TreeNode deserialize(String[] data,int []id) {
        int i=id[0];
         if(i>=data.length ||data[i].equals("#")){
             id[0]++;
             return null;
         }
         TreeNode root=new TreeNode(Integer.parseInt(data[id[0]]));
         id[0]++;
        root.left= deserialize(data,id);
         root.right=deserialize(data,id);
         return root;
    }
    public TreeNode deserialize(String data) {
        String []arr=data.split(" ");
        int []id=new int[1];
        return deserialize(arr,id);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));