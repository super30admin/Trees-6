//Time Complexity-O(n) number of nodes
//Space Complexity-O(n) where n is number of nodes in  level
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>>output=new ArrayList();
        if(root==null)
        {
            return output;
        }
        int min=0;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,ArrayList<Integer>>map=new HashMap();
        Queue<Pair<TreeNode,Integer>>queue=new LinkedList();
        queue.add(new Pair<TreeNode,Integer>(root,0));
        while(!queue.isEmpty())
        {
            Pair<TreeNode,Integer>front=queue.poll();
            TreeNode child=front.getKey();
            int val=front.getValue();
            min=Math.min(min,val);
            max=Math.max(max,val);
            map.putIfAbsent(val,new ArrayList<Integer>());
            map.get(val).add(child.val);
            if(child.left!=null)
            {
                queue.add(new Pair<TreeNode,Integer>(child.left,val-1));
            }
            if(child.right!=null)
            {
                queue.add(new Pair<TreeNode,Integer>(child.right,val+1));
            }
        }
        for(int i=min;i<=max;i++)
        {
            output.add(map.get(i));
        }
        return output;
    }
}