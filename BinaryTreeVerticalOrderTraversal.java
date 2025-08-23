
/**
 * Performs vertical order traversal of a binary tree using BFS.
 * Tracks column indices to group nodes by vertical levels.
 * Returns a list of node values grouped column by column.
 */
// Time Complexity: O(N), where N is the number of nodes in the tree

// Space Complexity: O(N), for the queue and hashmap storing nodes
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q;
        q = new LinkedList<>();
        int min = 0;
        int max = 0;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll(); 
            TreeNode currNode = curr.getKey();
            int currCol = curr.getValue();

            map.putIfAbsent(currCol, new ArrayList<>());
            map.get(currCol).add(currNode.val);

            if(currNode.left != null) {
                q.offer(new Pair(currNode.left, currCol -1));
                min = Math.min(min, currCol-1);
            }

            if(currNode.right != null) {
                q.offer(new Pair(currNode.right, currCol +1));
                max = Math.max(max, currCol +1);
            }
        }
        

        for (int i = min; i <= max; i++) {
            List<Integer> res = map.get(i);
            if (res != null) {
                result.add(res);
            }
        }
        return result;
    }
    
}
