class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        queue.add(root);
        column.add(0);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentColumn = column.poll();
            if(!map.containsKey(currentColumn)) {
                map.put(currentColumn, new ArrayList<>());
            }
            map.get(currentColumn).add(current.val);
            if(current.left != null) {
                queue.add(current.left);
                column.add(currentColumn-1);
                minimum = Math.min(minimum, currentColumn-1);
            }
            if(current.right != null) {
                queue.add(current.right);
                column.add(currentColumn+1);
                maximum = Math.max(maximum, currentColumn+1);
            }
        }
      for(int i = minimum ; i<=maximum;i++) {
        result.add(map.get(i));
      }
       return result;
    }
}