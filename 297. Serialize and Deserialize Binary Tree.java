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

        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if(node == null)
            {
                result.append("null");
                result.append(",");
                continue;
            }

            result.append(node.val);
            result.append(",");

            queue.add(node.left);
            queue.add(node.right);
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.length() == 0) return null;

        String[] strArray = data.split(",");
        int index = 1;

        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if(!strArray[index].equals("null"))
            {
                node.left = new TreeNode(Integer.parseInt(strArray[index]));
                queue.add(node.left);
            }

            // We have to even increment when we encounter a null. So we do it outside if
            index++;

            if(!strArray[index].equals("null"))
            {
                node.right = new TreeNode(Integer.parseInt(strArray[index]));
                queue.add(node.right);
            }

            // We have to even increment when we encounter a null. So we do it outside if
            index++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
