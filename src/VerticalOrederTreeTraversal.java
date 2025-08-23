//time complexity- O(n) where n is the total number of nodes
//space complexity- O(n)
import java.util.*;
public class VerticalOrederTreeTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        que.add(root);
        cols.add(0);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            int ind = cols.poll();
            if(!map.containsKey(ind)) map.put(ind, new ArrayList<>());
            map.get(ind).add(temp.val);

            if(temp.left != null) {
                que.offer(temp.left);
                cols.add(ind-1);
            }
            if(temp.right != null) {
                que.offer(temp.right);
                cols.add(ind+1);
            }
            min = Math.min(min, ind);
            max = Math.max(max, ind);
        }

        for(int i = min; i < max+1; i++) {
            sol.add(map.get(i));
        }
        return sol;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right= new TreeNode(9);
        root.left.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        root.left.left.right.right = new TreeNode(13);

        /*    Tree->
                                1
                            /       \
                           2         3
                        /    \     /   \
                      4       5  8      9
                      \     /   \      /   \
                      12   6      7   14    15
                         \
                           13

         */

        List<List<Integer>> sol = verticalOrder(root);
        System.out.println("The vertical order Traversal is:");
        for (List<Integer> li : sol) {
            System.out.println(li);
        }
    }
}
