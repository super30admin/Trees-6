// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("null");
            }else{
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            sb.append(",");

        }
        // System.out.println(sb.toString());
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //null
        if(data.length() == 0) return null;
        String[] splitArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int idx = 0;
        int rootVal = Integer.parseInt(splitArr[idx]);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        q.add(root);

        while(!q.isEmpty() && idx < splitArr.length){
            TreeNode curr = q.poll();
            if(!splitArr[idx].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            }
            idx++;
            if(!splitArr[idx].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.right);
            }
            idx++;
        }

        return root;
    }
}
