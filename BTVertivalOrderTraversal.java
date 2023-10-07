import java.util.*;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
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

public class BTVertivalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode> nodeq = new LinkedList<>();
        Queue<Integer> widthq = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();//O(n)
        int min=0, max=0;

        nodeq.add(root);
        widthq.add(0);

        while(!nodeq.isEmpty()){//O(n)
            TreeNode currNode = nodeq.poll();
            int currWidth = widthq.poll();

            if(!map.containsKey(currWidth)){
                map.put(currWidth, new ArrayList<>());
            }
            map.get(currWidth).add(currNode.val);
            min = Math.min(min, currWidth);
            max = Math.max(max, currWidth);

            if(currNode.left!=null){
                nodeq.add(currNode.left);
                widthq.add(currWidth-1);
            }

            if(currNode.right!=null){
                nodeq.add(currNode.right);
                widthq.add(currWidth+1);
            }
        }

        for(int i=min; i<=max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
