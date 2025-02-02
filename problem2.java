import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
// Time complexity: O(W*B)
// Space Complexity: O(W*B)
public class problem2{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr!=null)
            {
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            else {
                sb.append("#");
            }
        }
        return sb.toString();

    }
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[idx]));
        idx++;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (!tokens[idx].trim().equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[idx]));
                q.add(curr.left);
            }
//        else {
//            curr.left=null;
//        }
            idx++;
            if (!tokens[idx].trim().equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[idx]));
                q.add(curr.right);
            }
//        else {
//            curr.right=null;
//        }
            idx++;
        }
        return root;
    }
}
