import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Map<Integer, List<Integer>> columnMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        
        queue.offer(root);
        columnQueue.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int column = columnQueue.poll();
            
            // Add the current node's value to the column's list
            columnMap.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);
            
            // Process left child
            if (node.left != null) {
                queue.offer(node.left);
                columnQueue.offer(column - 1);
            }
            
            // Process right child
            if (node.right != null) {
                queue.offer(node.right);
                columnQueue.offer(column + 1);
            }
        }
        
        // Convert the column map to the result list
        result.addAll(columnMap.values());
        
        return result;
    }
}

