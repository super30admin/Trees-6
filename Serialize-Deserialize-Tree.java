//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Perform bfs to serialize the tree and store it in the string StringBuilder
// for deserializing traverse through the array and by pushing the curr element into the Queue
// and increment the pointers in such a way that first element is the left child and next element is right child.
// so push first element and increment i so that its the right child and second next is right and push those in Queues
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
        if(root == null) return sb.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr != null)
            {
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);
                q.add(curr.right);
                
            }
            else
            {
                sb.append("null");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if(data.length() == 0) return null;
        int i =0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        q.add(root);
        i++;
        while(!q.isEmpty() && i < arr.length)
        {
            TreeNode curr = q.poll();
            if(!arr[i].equals("null"))
            {
                TreeNode val = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = val; 
                q.add(val);
            }
            i++;
            if(!arr[i].equals("null"))
            {
                TreeNode val = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = val;
                q.add(val);
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