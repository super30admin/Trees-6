package S30.Trees_6;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/*
Time Complexity : O(n) - touching every node
Space Complexity : O(n)[hashmap size] + O(h)[stackframe height] + O(n/2)[queue size]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/


public class BinaryTreeVerticalOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        if(root == null) return result;
        int minval = 0; int maxval = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        cols.add(0); nodes.add(root);
        while(!nodes.isEmpty()){

            TreeNode curr = nodes.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);

            if(curr.left != null){
                nodes.offer(curr.left);
                cols.offer(col-1);
                minval = Math.min(minval,col-1);
            }

            if(curr.right != null){
                nodes.offer(curr.right);
                cols.offer(col+1);
                maxval = Math.max(maxval,col+1);
            }
        }

        for(int i = minval; i <= maxval; i++){
            result.add(new ArrayList<>(map.get(i)));
        }

        return result;
    }
}
