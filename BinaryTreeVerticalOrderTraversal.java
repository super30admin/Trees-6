// Time Complexity : O(n) where n is the no. of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Mark all the nodes according to the vertical levels
// Root being the centre point and left side nodes would be -ve and right side would be +ve
// Now perform level order traversal and simultaneously put all the nodes in map
// in accordance with the vertical levels. Also maintain min value of key
// Now traverse the map from min value till the key doesn't exist and add all the lists to result
// Finally return the result.
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
    Map<Integer, List<Integer>> hm;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        hm = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        if(root != null)
            q.add(new Pair(root, 0));
        int minLevel = 0;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            TreeNode node = cur.node;
            int level = cur.level;
            minLevel = Math.min(minLevel, level);
            if(!hm.containsKey(level)){
                hm.put(level, new ArrayList<>());
            }
            hm.get(level).add(node.val);
            if(node.left != null)
                q.add(new Pair(node.left, level - 1));
            if(node.right != null)
                q.add(new Pair(node.right, level + 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        while(hm.containsKey(minLevel)){
            result.add(hm.get(minLevel));
            minLevel++;
        }
        return result;
    }
    
}
class Pair{
        TreeNode node;
        int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
    }