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
// Approach : By using BFS and tracking width in a seperate queue and process the left node by adding -1 to the parent nodes width and similary 
// process the rigt node by adding 1 to the parent width.
// Time :  O(n) + O(minWidth , maxWidth) = n/2 levels = O(n)
// Space : O(n)
class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        this.result= new ArrayList<>();
        if(root == null) return result;

        HashMap<Integer ,List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        Queue<Integer> widthQ = new LinkedList<>();
        widthQ.add(0);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int width = widthQ.poll();

            map.putIfAbsent(width, new ArrayList<>());
            map.get(width).add(curr.val);
            min = Math.min(min,width);
            max = Math.max(max,width);

            if(curr.left!=null){
                widthQ.add(width -1);
                q.add(curr.left);
            }

            if(curr.right!=null){
                widthQ.add(width+1);
                q.add(curr.right);
            }
        }
        System.out.println(map);
        for(int i = min;i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }
}


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
// Approach : By Using DFS along with height information and maintaining the map
// Time : O(n) // To traverse the tree & creating Map + n/2 * klogk
// Space :
class Solution {
    List<List<Integer>> result;
    HashMap<Integer ,List<int[]>> map;
    int max , min ;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        this.result = new ArrayList<>();
        this.map = new HashMap<>();
        this.min = 0;
        this.max=0;
        if(root == null) return result;
        dfs(root,0,0); // maintain width and height

        for(int i=min;i<=max;i++){
            List<int[]> currList = map.get(i);
            // sort them based off height
            Collections.sort(currList,(a,b)->a[1]-b[1]);
            List<Integer> re = new ArrayList<>();
            for(int[] element:currList){
                re.add(element[0]);
            }

            result.add(re);
        }
        return result;
        
    }
    private void dfs(TreeNode root , int width , int height){
        // Base case
        if(root == null) return;
        
        min = Math.min(min,width);
        max = Math.max(max,width);

        map.putIfAbsent(width, new ArrayList<>());
        map.get(width).add(new int[]{root.val,height});

        // Traverse to left 
        dfs(root.left,width-1,height+1);
        // Traverse to right
        dfs(root.right,width+1,height+1);

    }
}

