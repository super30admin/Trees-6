/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Compexity: O(N)
// Space Complexity: O(N), uses BFS

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    	if(root == null) return "";

    	StringBuilder sb = new StringBuilder();
    	Queue<TreeNode> q = new LinkedList<>();

    	q.add(root);

    	while(!q.isEmpty()) {
    		TreeNode current = q.poll();
    		if(current == null) {
    			sb.append("null,");
    			continue;
    		}

    		sb.append("" + current.val + ",");
    		q.offer(current.left);
    		q.offer(current.right);

    	}

    	return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;

        String[] tokens = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        q.add(root);

        int cursor = 1;

        while(!q.isEmpty()) {
        	TreeNode current = q.poll();

        	if(!tokens[cursor].equals("null")) {
        		current.left = new TreeNode(Integer.parseInt(tokens[cursor]));
        		q.add(current.left);
        	}
        	cursor++;

        	if(!tokens[cursor].equals("null")) {
        		current.right = new TreeNode(Integer.parseInt(tokens[cursor]));
        		q.add(current.right);
        	}
        	cursor++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));