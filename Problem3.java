import java.util.*;

/*
Vertical order tree traversal
approach: dfs: we have to keep track of the level and depth for each node
to overcome the drawback in dfs, we can do a bfs
time: O(n)
space: O(n)
 */
public class Problem3 {
    HashMap<Integer, List<Integer>> res;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private List<List<Integer>> verticalOrderTraversal(Problem2.TreeNode root) {
        res = new HashMap<>();
        dfs(root, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=min; i<=max; i++) {
            result.add(res.get(i));
        }
        return result;
    }

    private void dfs(Problem2.TreeNode root, int depth) {
        if (root==null) return;
        min = Math.min(min, depth);
        max = Math.max(max, depth);
        if (!res.containsKey(root.val)) {
            res.put(depth, new ArrayList<>());
        }
        res.get(depth).add(root.val);
        if (root.left!=null) dfs(root.left, depth-1);
        if (root.right!=null) dfs(root.right, depth+1);
    }

    private List<List<Integer>> verticalOrderTraversalBFS(Problem2.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        Queue<Problem2.TreeNode> q = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        q.add(root);
        depth.add(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Problem2.TreeNode popped = q.poll();
            int dep = depth.poll();
            if (!res.containsKey(dep)) {
                res.put(dep, new ArrayList<>());
            }
            res.get(dep).add(popped.val);
            if (popped.left!=null) {
                q.add(popped.left);
                depth.add(dep-1);
                min = Math.min(min, dep-1);
            }
            if (popped.right!=null) {
                q.add(popped.right);
                depth.add(dep+1);
                max = Math.max(max, dep+1);
            }
        }
        for (int i=min; i<=max; i++) {
            result.add(res.get(i));
        }
        return result;
    }
}
