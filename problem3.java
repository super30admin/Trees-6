import java.util.*;

public class problem3 {
    public class TreeNode {
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

    //using bfs
    // Time Complexity: O(n) + O(n)
    // Space Complexity: O(n)
    List<List<Integer>> res ;
    public List<List<Integer>> verticalOrderbfs(TreeNode root) {
        res= new ArrayList<>();
        if (root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<Integer> level = new LinkedList<>();
        level.add(0);
        int min=0, max=0;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int currWidth= level.poll();
            map.putIfAbsent(currWidth, new ArrayList<>());
            map.get(currWidth).add(curr.val);
            if (curr.left != null)
            {
                q.add(curr.left);
                level.add(currWidth-1);
                min= Math.min(min, currWidth-1);
            }
            if (curr.right != null)
            {
                q.add(curr.right);
                level.add(currWidth+1);
                max= Math.max(max, currWidth+1);
            }
        }
        for (int i=min; i<=max; i++)
        {
            res.add(map.get(i));
        }
        return res;
    }
    //using dfs
    // Time Complexity: O(n) + O(n(klogk))
    // Space Complexity: O(n )
    List<List<Integer>> res1;
    HashMap<Integer, List<int[]>> map;
    int min = 0, max = 0;
    //int min=0, max=0;
    public List<List<Integer>> verticalOrderdfs(TreeNode root) {
        this.res1 = new ArrayList<>();
        if (root == null) return res1;

        this.map = new HashMap<>();
        this.min = 0;
        this.max = 0;

        dfs(root, 0, 0);

        for (int i = min; i <= max; i++) {
            List<int[]> currList = map.get(i);
            currList.sort(Comparator.comparingInt(a -> a[1])); // Sort by height

            List<Integer> re = new ArrayList<>();
            for (int[] el : currList) {
                re.add(el[0]);
            }
            res1.add(re);
        }
        return res1;
    }
    private void dfs(TreeNode root, int level, int height) {
        if (root == null) return;

        min = Math.min(min, level);
        max = Math.max(max, level);

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(new int[]{root.val, height});

        dfs(root.left, level - 1, height + 1);
        dfs(root.right, level + 1, height + 1);

    }

}
