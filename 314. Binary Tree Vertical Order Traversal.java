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
     class Pair
    {
        TreeNode node;
        int dir;

        Pair(TreeNode node, int dir)
        {
            this.node = node;
            this.dir = dir;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root == null) return new ArrayList();

        HashMap<Integer, List<Integer>> map = new HashMap();
        List<List<Integer>> result = new ArrayList();

        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(root, 0));

        int maximum = 0, minimum = 0;

        while(!queue.isEmpty())
        {
            Pair p = queue.poll();

            if(!map.containsKey(p.dir)) map.put(p.dir, new ArrayList());

            map.get(p.dir).add(p.node.val);

            if(p.node.left != null)
            {
                queue.add(new Pair(p.node.left, p.dir - 1));
                minimum = Math.min(minimum, p.dir - 1);
            }

            if(p.node.right != null)
            {
                queue.add(new Pair(p.node.right, p.dir + 1));
                maximum = Math.max(p.dir + 1, maximum);
            }
        }

        for(int i = minimum; i <= maximum; i++) result.add(map.get(i));

        return result;
    }
}
