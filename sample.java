// Range Sum of BST
// Time Complexity: O(V + E)
// Space Complexity: O(n) for queue

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // base condition
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        // while condition - until queue is not empty
        while (!queue.isEmpty()) {
            // get size of the queue
            int size = queue.size();
            // loop over the size
            for (int i=0; i<size; i++) {
                // get the top of the queue
                TreeNode node = queue.poll();
                // if val is between range, add to the sum
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }
                // if left present, add to queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                // if right present, add to queue
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        return sum;
    }
}

// Serialize and Deserialize Binary Tree
// Time Complexity: O(V + E)
// Space Complexity: O(n) for recursive stack

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
    // recursive serialize function
    private String rserialize(TreeNode root, String str){
        // if null, then add null
        if (root == null) {
            str += "null,";
            return str;
        }
        // add val + ','
        str = str + root.val + ",";
        // recursive call on left tree
        str = rserialize(root.left, str);
        // recursive call on right tree
        str = rserialize(root.right, str);
        
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
        
    }
    // recursive deserialize function
    private TreeNode rdeserialize(List<String> list) {
        // if null, then remove the element and return null
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        // the first element in the list is root
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        // remove first element
        list.remove(0);
        // recursion for left 
        root.left = rdeserialize(list);
        // recursion for right
        root.right = rdeserialize(list);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // convert string to array
        String[] arr = data.split(",");
        // array to arraylist
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        
        return rdeserialize(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
