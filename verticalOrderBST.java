import java.util.*;
class verticalOrderBST {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(100);
        root.right.left = new TreeNode(50);
        System.out.println(verticalOrder(root).toString());
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        col.add(0);
        int max = 0;
        int min = 0;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            int column = col.poll();

            if(!map.containsKey(column)) {
                map.put(column,new ArrayList<>());
            } 
            map.get(column).add(curr.val);
            if(curr.left != null) {
                q.add(curr.left);
                col.add(column-1);
                min = Math.min(min, column -1);
            }
            if(curr.right != null) {
                q.add(curr.right);
                col.add(column + 1);
                max = Math.max(max, column + 1);
            }

        }
        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;

        
    }
}
class TreeNode {
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