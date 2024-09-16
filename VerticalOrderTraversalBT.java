// Time Complexity: O(n)
// Space Complexity: O(n)
public class VerticalOrderTraversalBT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.offer(root);
        cols.offer(0);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            if(!map.containsKey(col))
                map.put(col, new ArrayList<>());
            
            map.get(col).add(curr.val);
            
            if(curr.left != null)
            {
                q.offer(curr.left);
                cols.add(col-1);
            }
            
            if(curr.right != null)
            {
                q.offer(curr.right);
                cols.add(col+1);
            }
        }
        
        for(int i = min; i <= max; i ++)
        {
            
            result.add(map.get(i));
        }
        
        return result;
    }
}
