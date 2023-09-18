import java.util.*;

public class VerticalOrderTreeTraversal {
    private class Pair{
        TreeNode node;
        int order;
        public Pair(TreeNode root, int i) {
            this.node = root;
            this.order = i;
        }

        public TreeNode getKey() {
            return node;
        }

        public int getValue() {
            return order;
        }
    }

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minOrder = Integer.MAX_VALUE;
        int maxOrder = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode curr = current.getKey();
            int order = current.getValue();
            minOrder = Math.min(minOrder, order);
            maxOrder = Math.max(maxOrder, order);
            if(!map.containsKey(order)) map.put(order, new ArrayList<>());

            map.get(order).add(curr.val);

            if(curr.left !=null) queue.offer(new Pair(curr.left, order-1));
            if(curr.right !=null) queue.offer(new Pair(curr.right, order+1));
        }


        List<List<Integer>> list = new ArrayList<>();
        for(int i = minOrder; i<= maxOrder; i++){
            list.add(map.get(i));
        }
        return list;
    }


}
