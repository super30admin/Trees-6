//Time Complexity : O(2n) ~ O(n)
//Space Complexity : O(n)
//Did this code run successfully on leetcode : yes
//Any problem you faced while writing this: No
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
class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> widthQueue = new LinkedList<>();

        nodeQueue.add(root);
        widthQueue.add(0);

        while(!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int currWidth = widthQueue.poll();

            map.putIfAbsent(currWidth, new ArrayList<>());
            map.get(currWidth).add(currNode.val);

            min = Math.min(min, currWidth);
            max = Math.max(max, currWidth);

            if(currNode.left != null) {
                nodeQueue.add(currNode.left);
                widthQueue.add(currWidth - 1);
            }

            if(currNode.right != null) {
                nodeQueue.add(currNode.right);
                widthQueue.add(currWidth + 1);
            }
        }
        
        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;

    }
}