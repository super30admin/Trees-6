//https://leetcode.com/problems/binary-tree-vertical-order-traversal/

//Time Complexity: O(n)
//Space Complexity: O(n)
//BFS
class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> verticalOrder (TreeNode root){
        this. result = new ArrayList<>();
        //base case
        if(root == null) return result;

        Queue<TreeNode> nq = new LinkedList<>();
        Queue<Integer> wq = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        nq.add(root);
        wq.add(0);

        int min=0, max=0;

        while(!nq.isEmpty()){
            TreeNode curr = nq.poll();
            int currWidth = wq.poll();
            //put entry in HashMap
            if(!map.containsKey(currWidth)){
                map.put(currWidth, new ArrayList<>());
            }
            map.get(currWidth).add(curr.val);
            //add the left and right children to nq and wq
            if(curr.left != null){
                nq.add(curr.left);
                wq.add(currWidth-1);
                min = Math.min(min, currWidth-1);
            }
            if(curr.right != null){
                nq.add(curr.right);
                wq.add(currWidth+1);
                max = Math.max(max, currWidth+1);
            }
        }
        //print the lists of HashMap from min to max
        for(int i=min; i<=max; i++){
            result.add(map.get(i));
        }

        return result;
    }
}

//DFS: Not optimal than BFS and is unstable
//Time Complexity: O(n) + n(k*log(k)) ~ k is the size of the list
// i.e., O(n) + n(k^2)
//but the order of sorting won't be able to guarantee the order required [left -> right]

//Space Complexity: We will need width and depth information
class Solution {
    List<List<Integer>> result;
    HashMap<Integer, List<int[]>> map;
    int min, max;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        this.result = new ArrayList<>();
        this.min = 0;
        this.max = 0;
        this.map = new HashMap<>();

        // base case
        if (root == null) return result;

        dfs(root, 0, 0);

        // print the lists of HashMap from min to max
        for (int i=min; i<=max; i++) {
            List<int[]> currList = map.get(i);
            //sort according to depth
            Collections.sort(currList, (a,b)-> a[1] - b[1]); //a[0]: value, a[1]:height
            List<Integer> tempList = new ArrayList<>();
            for(int[] ele : currList){
                tempList.add(ele[0]);
            }
            result.add(tempList);
        }
        return result;
    }

    private void dfs(TreeNode root, int width, int depth) {
        // base case
        if (root == null) return;

        min = Math.min(min, width);
        max = Math.max(max, width);

        // put entry in HashMap
        if (!map.containsKey(width)) {
            map.put(width, new ArrayList<>());
        } //add root along with depth info
        map.get(width).add(new int[]{root.val, depth});

        // left recursion
        dfs(root.left, width - 1, depth + 1);
        // right recursion
        dfs(root.right, width + 1, depth + 1);
    }
}