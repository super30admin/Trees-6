/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // List to store the final result of vertical order traversal
        List<List<Integer>> result = new ArrayList<>();
        
        // Map to store nodes at each vertical level, where keys are horizontal distances
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        // Queue for BFS traversal, storing pairs of nodes and their corresponding horizontal distance
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        
        // If the root is null, return an empty result
        if (root == null) return result;
        
        // Initialize the queue with the root node and its horizontal distance (0)
        que.add(new Pair(root, 0));
        
        // Perform BFS traversal
        while (!que.isEmpty()) {
            // Dequeue the front element, which includes the node and its horizontal distance
            Pair<TreeNode, Integer> currentPair = que.poll();
            TreeNode currentRoot = currentPair.getKey();
            int key = currentPair.getValue();
            
            // If the map does not contain the current horizontal distance, add a new entry
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            
            // Add the current node's value to the list corresponding to its horizontal distance
            map.get(key).add(currentRoot.val);
            
            // Add the left child to the queue with its horizontal distance decreased by 1
            if (currentRoot.left != null) {
                que.add(new Pair(currentRoot.left, key - 1));
            }
            
            // Add the right child to the queue with its horizontal distance increased by 1
            if (currentRoot.right != null) {
                que.add(new Pair(currentRoot.right, key + 1));
            }
        }
        
        // Add all lists of node values from the map to the result list
        for (ArrayList<Integer> values : map.values()) {
            result.add(Collections.sort(values));

        }

        return result;
    }
}
