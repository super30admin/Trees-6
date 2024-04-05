// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: 
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> hm = new HashMap();
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> cq = new LinkedList();
        int min=0; int max=0;
        List<List<Integer>>  result=new ArrayList();
        q.add(root);
        cq.add(0);
        if(root ==null)return result;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int ccol = cq.poll();
            if (!hm.containsKey(ccol)) {
                hm.put(ccol, new ArrayList());
            }
            hm.get(ccol).add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                cq.add(ccol - 1);
                min=Math.min(ccol-1,min);
            }
            if (null != cur.right) {
                q.add(cur.right);
                cq.add(ccol + 1);
                max=Math.max(ccol+1,max);
            }

        }
        for(int i=min;i<=max;i++){
            result.add(hm.get(i));
        }
    return result;
    }
}