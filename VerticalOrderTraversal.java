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
class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        
        HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        Queue<Integer> verticalOrderQueue = new LinkedList<>();
        int min = 0;
        int max = 0;

        myQueue.add(root);
        verticalOrderQueue.add(0);

        while(!myQueue.isEmpty()){
            TreeNode curr = myQueue.poll();
            Integer currVerticalOrder = verticalOrderQueue.poll();

            myMap.putIfAbsent(currVerticalOrder, new ArrayList<>());
            myMap.get(currVerticalOrder).add(curr.val);

            if(curr.left != null){
                myQueue.add(curr.left);
                verticalOrderQueue.add(currVerticalOrder-1);
                min = Math.min(min, currVerticalOrder-1);
            }

            if(curr.right != null){
                myQueue.add(curr.right);
                verticalOrderQueue.add(currVerticalOrder+1);
                max = Math.max(max, currVerticalOrder+1);
            }
        }
        for(int i=min; i<=max; i++){
            res.add(myMap.get(i));
        }
        return res;
    }
}

/**
 * Time Complexity: O(n) for traversing + O(n) for iterating over hashmap [Worst case, if Skewed Tree] => O(n)
 * Soace Complexity: O(3n) ~ O(n) for Hash Map, Queue's
 */


/* DFS */

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
        HashMap<Integer, ArrayList<int[]>> myMap;
        int max;
        int min;
        List<List<Integer>> res;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        this.res  = new ArrayList<>();
        this.myMap = new HashMap<>();

        if(root == null)
            return res;

        this.max = 0;
        this.min = 0;

        dfs(root, 0, 0);

        for(int i= min; i<=max; i++){
            List<Integer> re = new ArrayList<>();
            List<int[]> list = myMap.get(i);
            Collections.sort(list, (a,b) -> a[1]-b[1]);

            for(int[] element: list){
                re.add(element[0]);
            }
            res.add(re);
        }
        return res;
    }

     private void dfs(TreeNode root, int width, int height){
            if(root == null)
                return;
            
            min = Math.min(min, width);
            max = Math.max(max, width);

            myMap.putIfAbsent(width, new ArrayList<>());
            myMap.get(width).add(new int[]{root.val, height});

            dfs(root.left, width-1, height+1);
            dfs(root.right, width+1, height+1);
        }
}


/**
 * Time Complexity: O(n)[Traversing] + n(k(logk))[Sorting based on height for each element [worst case n].]
 * Soace Complexity: O(3n) ~ O(n) for Hash Map, Queue's
 */