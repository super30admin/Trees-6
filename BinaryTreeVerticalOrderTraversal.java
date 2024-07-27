import java.util.*;

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
class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        nodes.add(root);
        values.add(0);

        while(!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            int currVal = values.poll();

            min = Math.min(min, currVal);
            max = Math.max(max, currVal);

            if(!map.containsKey(currVal)) {
                map.put(currVal, new ArrayList<>());
            }
            map.get(currVal).add(currNode.val);

            if(currNode.left != null) {
                nodes.add(currNode.left);
                values.add(currVal - 1);
            }

            if(currNode.right != null) {
                nodes.add(currNode.right);
                values.add(currVal + 1);
            }
        }

        for(int i=min; i<=max; i++) {
            List<Integer> list = map.get(i);
            result.add(list);
        }

        return result;
    }
    class TreeNode {
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
}