import java.util.*;


// Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class VerticalTraversal {

      // BFS approach. DFS won't give the traversal order expected in the question
      // TC : O(n) n - number of nodes in a given tree
    // SC : O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        cols.add(0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);

            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);

            if(curr.left != null){
                q.add(curr.left);
                cols.add(col - 1);
            }

            if(curr.right != null) {
                q.add(curr.right);
                cols.add(col + 1);
            }
        }

        for(int i=min; i <= max; i++) {
            List<Integer> list = map.get(i);
            result.add(list);
        }

        return result;
    }
}
