import java.util.*;

public class VerticalBTTraversal {
    public List<List<Integer>> verticalTraverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<>(); // result list

        if( root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); // Queue to store the nodes for BFS traversal
        Queue<Integer> col = new LinkedList<>(); // queue for coloumn index
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // hashmap to store mapping of each index with the correspondign nodes

        int min =0, max =0;

        queue.add(root);
        col.add(0);

        while( ! queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int colIndex = col.poll();

            if (!map.containsKey(colIndex)) {
                map.put(colIndex, new ArrayList<>());
            }
            map.get(colIndex).add(curr.val);

            if (curr.left != null) {
                queue.add(curr.left);
                col.add(colIndex - 1);
                min = Math.min(min, colIndex - 1);
            }

            if (curr.right != null) {
                queue.add(curr.right);
                col.add(colIndex + 1);
                max = Math.max(max, colIndex + 1);
            }
        }

            for( int i = min; i <= max; i++){
                result.add(map.get(i));

            }

        return result;


    }

    public static void main (String [] args){
        VerticalBTTraversal solution = new VerticalBTTraversal();

        // Construct the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Call verticalOrder function
        List<List<Integer>> result = solution.verticalTraverse(root);

        // Print the result
        System.out.println(result);
    }
}
