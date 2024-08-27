// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public List<List<Integer>> verticalOrder(TreeNode root){
    if(root == null){
        return new ArrayList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> col = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    q.add(root);
    col.add(0);
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        int currCol = col.poll();
        if(!map.containsKey(currCol)){
            map.put(currCol, new ArrayList<>());
        }
        map.get(currCol).add(curr.val);

        if(curr.left != null){
            q.add(curr.left);
            col.add(currCol - 1);
        }
        if(curr.right != null){    
            q.add(curr.right);
            col.add(currCol + 1);
        }
    }

    for(int i= min; i <= max; i++){
        List<Integer> row = map.get(i);
        result.add(row);
    }
    return result;
}