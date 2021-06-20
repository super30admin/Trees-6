//Time Complexity : O(n)
//Space Complexity : O(n). column Queue : O(n), node queue: O(n) and hashmap: O(n)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        int min=0,max=0;
        //queue to store the nodes in the BFS fashion
        Queue<TreeNode> q = new LinkedList<>();
        //queue to store the col number for each node in the "q" Queue
        Queue<Integer> col = new LinkedList<>();
        //map to store the cols and the respective nodes
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        q.add(root);
        col.add(0);
        //BFS
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int c = col.poll();
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(cur.val);
            //update the min and max, this will help in sorting
            min = Math.min(min,c);
            max = Math.max(max,c);
            //add the child nodes
            if(cur.left!=null){
                //for left node, sub one to the  col from its parent
                col.add(c-1);
                q.add(cur.left);
            }
            if(cur.right!=null){
                //for right node, add one to the col from its parent
                col.add(c+1);
                q.add(cur.right);
            }
        }
        //get the values from the map starting from min until max
        for(int i= min; i<=max;i++){
            result.add(map.get(i));
        }
        /*
        sort by using tree map
        TreeMap<Integer,List<Integer>> sort = new TreeMap<>(map);
        for(List<Integer> i : sort.values()){
            result.add(i);
        }
        */
        return result;
    }
}