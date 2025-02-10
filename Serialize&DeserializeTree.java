

import com.sun.source.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach : If you serialize using BFS - level order traversal then deserialize it using same
// Time : O(n)
// Space : O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr!=null){
                sb.append(curr.val);
                // add children to queue
                q.add(curr.left);
                q.add(curr.right);
            } else{
                sb.append('#');
            }
            sb.append(',');
        }
        System.out.println(sb.toString()); // 1,2,3,#,#,4,5,#,#,#,#,
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] splitArr = data.split(","); // [1 2 3 4 5 ]

        int idx =0;
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
        idx++;
        Queue<TreeNode> q = new LinkedList<>(); // need this queue to get the order of left and right children with parent as reference available in Queue
        q.add(root); 
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!splitArr[idx].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.left);
            } else{
                // not hash
                curr.left=null;
            }
            idx++;

            if(!splitArr[idx].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(splitArr[idx]));
                q.add(curr.right);
            } else{
                // not hash
                curr.right=null;
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach : If you serialize using DFS - Recursion with Pre order/Post Order traversal then deserialize it using same
// Time : O(n)
// Space : O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        dfsSerialize(root,sb);
        return sb.toString();

    }
    private void dfsSerialize(TreeNode root, StringBuilder sb){
        // Base case;
        if(root == null){
            sb.append('#');
            sb.append(",");
            return;
        }

        sb.append(root.val);
        sb.append(",");

        dfsSerialize(root.left,sb);
        dfsSerialize(root.right,sb);
    }

    // Decodes your encoded data to tree.

    int idx;
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        this.idx =0;
        
        String[] splitArr = data.split(",");
        return dfsDeserialize(splitArr);
    }

    private TreeNode dfsDeserialize(String[] splitArr){
        // Base case
        if(splitArr[idx].equals("#")){
            idx++;
            return null;
        }

        // Pre Order
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
        idx++;
        root.left = dfsDeserialize(splitArr);
        root.right = dfsDeserialize(splitArr);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach : If you serialize using DFS - Recursion with Pre order/Post Order traversal then deserialize it using same
// Time : O(n)
// Space : O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        dfsSerialize(root,sb);
        return sb.toString();

    }
    private void dfsSerialize(TreeNode root, StringBuilder sb){
        // Base case;
        if(root == null){
            sb.append('#');
            sb.append(",");
            return;
        }

        // Post Order - left baby- right baby - root

        dfsSerialize(root.left,sb);
        dfsSerialize(root.right,sb);

        sb.append(root.val);
        sb.append(",");

    }

    // Decodes your encoded data to tree.

    int idx;
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String[] splitArr = data.split(",");
        this.idx = splitArr.length-1;
        
        
        return dfsDeserialize(splitArr);
    }

    private TreeNode dfsDeserialize(String[] splitArr){
        // Base case
        if(splitArr[idx].equals("#")){
            idx--;
            return null;
        }

        // Post Order - root - right - left
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
        idx--;
        root.right = dfsDeserialize(splitArr);
        root.left = dfsDeserialize(splitArr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));