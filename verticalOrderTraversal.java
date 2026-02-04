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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(); 
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int min = 0,max = 0;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int level = curr.level;
            min = Math.min(min,level);
            max = Math.max(max, level);

            if(!map.containsKey(level))
                map.put(level, new ArrayList<>());

            map.get(level).add(node.val);

            if(node.left != null)
                q.offer(new Pair(node.left, level-1));
            if(node.right != null)
                q.offer(new Pair(node.right, level+1));
        }

        for(int i = min; i<= max; i++)
            result.add(map.get(i));
        
        return result;
    }

    class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}