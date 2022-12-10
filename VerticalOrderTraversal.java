
 //Time - O(n)
 //Space - O(n)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> l = new LinkedList<>();
        q.add(root);
        l.add(0);
        int min = 0;
        int max =0;
        while(!q.isEmpty()){
           TreeNode node = q.poll();
           int lv = l.poll();
            if(!map.containsKey(lv)){
                map.put(lv, new ArrayList<>());
            }
            map.get(lv).add(node.val);
            if(node.left!=null){
                q.add(node.left);
                l.add(lv-1);
                min = Math.min(min,lv-1);
            }
            if(node.right!=null){
                q.add(node.right);
                l.add(lv+1);
                max = Math.max(max,lv+1);
            }
            
        }
        for(int i=min; i<=max; i++){
            result.add(map.get(i));
        }
        return result;

    }
}