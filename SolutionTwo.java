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
* TC O(n)
* SC O(n)
* */
public class SolutionTwo
{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {


        StringBuilder sb = new StringBuilder();

        if(root == null)
            return sb.toString();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();

            if(curr!=null)
            {
                sb.append(curr.val);
                sb.append(",");
                queue.add(curr.left);
                queue.add(curr.right);
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
    public TreeNode deserialize(String data)
    {
        if(data == null || data.equals("") || data.equals("null"))
            return null;

        String[] strArr = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));

        queue.add(root);

        int i = 1;

        while(!queue.isEmpty() && i < strArr.length)
        {
            TreeNode curr = queue.poll();

            //left child
            if(!strArr[i].equals("null"))
            {
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(curr.left);
            }
            i++;

            //right child
            if(!strArr[i].equals("null"))
            {
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(curr.right);
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