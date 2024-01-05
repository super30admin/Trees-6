// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class SerializeAndDeserialize {
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
            if(root == null)
                return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode curr = q.poll();

                if(curr == null){
                    sb.append("#").append(",");
                }
                else{
                    sb.append(curr.val).append(",");

                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            //System.out.println(sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length() == 0 || data == null)
                return null;

            //1,2,3,#,#,4,5,#,#,#,#,
            String[] arr = data.split(",");
            //System.out.println(Arrays.toString(arr));
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int idx = 1;

            while(!q.isEmpty()){
                TreeNode curr = q.poll();

                //left child
                if(!arr[idx].equals("#")){
                    TreeNode newNode = new TreeNode(Integer.parseInt(arr[idx]));
                    q.add(newNode);
                    curr.left = newNode;
                    idx++;
                }
                else{
                    idx++;
                }

                //right child
                if(!arr[idx].equals("#")){
                    TreeNode newNode = new TreeNode(Integer.parseInt(arr[idx]));
                    q.add(newNode);
                    curr.right = newNode;
                    idx++;
                }
                else{
                    idx++;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
