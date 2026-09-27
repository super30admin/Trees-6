//problem1
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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;
    }
    public int helper(TreeNode root,int low,int high){
        if(root==null) return 0;
        if(root.val>=low && root.val<=high){
            sum+=root.val;
        }
        helper(root.left,low,high);
        helper(root.right,low,high);
        return sum;
    }
}
//problem2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr!=null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] splitarr=data.split(",");
        int idx=0;
        TreeNode root=new TreeNode(Integer.parseInt(splitarr[idx]));
        idx++;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(!splitarr[idx].equals("#")){
                curr.left=new TreeNode(Integer.parseInt(splitarr[idx]));
                q.add(curr.left);
            }
            idx++;
            if(!splitarr[idx].equals("#")){
                curr.right=new TreeNode(Integer.parseInt(splitarr[idx]));
                q.add(curr.right);
            }
            idx++;
        }
        return root;
    }
}

//problem3
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> list = new ArrayList<>();

        dfs(root, 0, 0, list);

        Collections.sort(list, (a, b) -> {
            // first sort by column
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            // then sort by row
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            // if row and column are same, sort by value
            return a[2] - b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();

        int prevColumn = Integer.MIN_VALUE;

        for (int[] node : list) {

            int row = node[0];
            int column = node[1];
            int value = node[2];

            if (column != prevColumn) {
                ans.add(new ArrayList<>());
                prevColumn = column;
            }

            ans.get(ans.size() - 1).add(value);
        }

        return ans;
    }

    public void dfs(TreeNode root, int row, int column, List<int[]> list) {

        if (root == null) {
            return;
        }

        list.add(new int[]{row, column, root.val});

        dfs(root.left, row + 1, column - 1, list);

        dfs(root.right, row + 1, column + 1, list);
    }
}
