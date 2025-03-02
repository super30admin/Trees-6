package Trees-6;

public class BinaryTreeVerticalTraverse {
    public List<List<Integer>> verticalOrder(TreeNode root) {
       
        HashMap<Integer, List<Integer>> lmap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
         if(root == null){
            return result;
        }
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            int idx = p.getValue();
            TreeNode node = p.getKey();
            if (lmap.get(idx) == null) {
                lmap.put(idx, new ArrayList<Integer>());
                lmap.get(idx).add(node.val);
            }else{
                lmap.get(idx).add(node.val);
            }
            
            max = Math.max(max, idx);
            min = Math.min(min, idx);

            if (node.left != null) {
                q.add(new Pair(node.left, idx - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, idx + 1));
            }
        }

        for(int i=min;i<=max;i++){
            result.add(lmap.get(i));
        }
        return result;
    }
}
