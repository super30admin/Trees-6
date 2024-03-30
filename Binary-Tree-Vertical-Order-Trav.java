// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using column vise traversal, assign col values to each node. Using Queue start BFS traversal.

// 94. Binary Tree Vertical Order Traversal

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    //   Definition for a binary tree node.
public class TreeNode {
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
        if(root == null) return result;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        q.add(root);col.add(0);
        int min=0;int max=0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int currCol = col.poll();
            if(!map.containsKey(currCol)){
                map.put(currCol,new ArrayList<>());
            }
            map.get(currCol).add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
                col.add(currCol-1);
                min = Math.min(min,currCol-1);
            }
            if(curr.right != null){
                q.add(curr.right);
                col.add(currCol+1);
                max = Math.max(max,currCol+1);
            }
        }
        for(int i=min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}