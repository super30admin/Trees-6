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
/*
Time Complexity:O(n)
Space Complexity: O(w)+O(n) where w is the width and n is the number of elements
*/
import java.util.*;

class Using{
TreeNode x;
int col;
Using(TreeNode x,int col){
this.x=x;
this.col=col;
}
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        Using x=new Using(root,0);
        Queue<Using> a=new LinkedList<Using>();
        HashMap<Integer,List<Integer>> sol=new HashMap<>(); 
        a.add(x);
        int min=0,max=0;
        while(!a.isEmpty()){
            Using current=a.poll();
            // System.out.println(current.col);
            if(max<current.col){
            max=current.col;
            }
            if(min>current.col){
            min=current.col;
            }
            if(!sol.containsKey(current.col)){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(current.x.val);
                sol.put(current.col,temp);
            }
            else{
                sol.get(current.col).add(current.x.val);
            }
            //next line
            if(current.x.left!=null){
            a.add(new Using(current.x.left,current.col-1));
            }
            if(current.x.right!=null){
            a.add(new Using(current.x.right,current.col+1));
            }
        }
        System.out.println(min);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=min;i<=max;i++){
        if(sol.containsKey(i)){
        res.add(sol.get(i));
        }
        }
        return res;
    }
}