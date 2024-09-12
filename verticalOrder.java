// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
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
        
        List<List<Integer>> ans = new ArrayList();
        if(root==null)
            return ans;
        
        Queue<HdNode> q = new LinkedList();
        Map<Integer, List<Integer>> map = new HashMap();
        
        int hd = 0;
        int minhd = 0; 
        int maxhd = 0;
        
        q.add(new HdNode(root,hd));
        
        while(!q.isEmpty()) {
            
            HdNode curr = q.poll();
            
            minhd = Math.min(minhd,curr.hd);
            maxhd = Math.max(maxhd,curr.hd);
            
            map.putIfAbsent(curr.hd, new ArrayList());
            map.get(curr.hd).add(curr.node.val);
            
            if(curr.node.left!=null) {
                q.add(new HdNode(curr.node.left, curr.hd-1));
            }
            if(curr.node.right!=null) {
                q.add(new HdNode(curr.node.right, curr.hd+1));
            }
            
        }
        
        while(minhd<=maxhd) {
            ans.add(map.get(minhd));
            minhd++;
        }
        
        return ans;
    }
    
}

class HdNode{
    
    TreeNode node;
    int hd;
    
    public HdNode(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
    
}
