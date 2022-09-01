//TC : O(N) 
//SC : O(N) as we used queue and Map

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // To keep track of nodes in each column(Level)
        Queue<TreeNode> queue = new LinkedList<>();
        
        Queue<Integer> depth = new LinkedList<>(); // Keeps track of depth(Of column/vertically) for each corresponding node in queue
        
        queue.add(root);
        depth.add(0);
        map.put(0, new ArrayList<>());
        int min = 0; int max = 0;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int wd = depth.poll();
            
            min = Math.min(min, wd);
            max = Math.max(max, wd);
            
            List<Integer> list = map.getOrDefault(wd, new ArrayList<>()); // Adding nodes at particular depth(Of column/vertically)
            list.add(curr.val);
            map.put(wd, list);
            
            if(curr.left != null){ // For going in left direction, decresing depth by 1
                queue.add(curr.left);
                depth.add(wd - 1);
            }
            if(curr.right != null){// For going in right direction, increasing depth by 1
                queue.add(curr.right);
                depth.add(wd + 1);
            }            
        }
        
        
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
        
        
    }
}
