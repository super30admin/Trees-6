//TC: O(n) where n is total no. of nodes in BT
//SC: O(n) for hashmap and queue

//CODE:

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        //taking 2 queues one for adding nodes and other for adding the width
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        q.add(root);
        cols.add(0);
        int min=0; int max=0;
        while(!q.isEmpty()){
            int col = cols.poll();
            TreeNode curr = q.poll();
            List<Integer> li = map.getOrDefault(col, new ArrayList<>()); //if that width exists then take out that list else get a new list
            li.add(curr.val);
            map.put(col,li);
            max = Math.max(col,max);
            min = Math.min(col,min);
            if(curr.left!= null){ //going towards left child and as we go we decrease the width by 1
                q.add(curr.left);
                cols.add(col-1);
            }
            if(curr.right!= null){ //going towards right child and as we go we increase the width by 1
                q.add(curr.right);
                cols.add(col+1);
            }
        }
        for(int i = min; i<=max;i++){ //iterating from min width to max width and storing it in a list
            result.add(map.get(i));
        }
        return result;
    }
}