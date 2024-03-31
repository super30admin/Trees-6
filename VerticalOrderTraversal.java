public class VerticalOrderTraversal {
    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currNode = curr.getKey();
            int index = curr.getValue();
            min = Math.min(min, index);
            max = Math.max(max, index);
            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(currNode.val);
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, index - 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, index + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
