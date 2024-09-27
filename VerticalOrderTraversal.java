import java.util.*;

public class VerticalOrderTraversal {
   
    class ColumnTree {
        TreeNode node;
        int index;
        
        public ColumnTree(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    //TC: O(N) Traverse all the node
    //SC: O(N) At the worst case all nodes will be in the queue.


    //Regular BFS approach. If we go left reduce the column index, else increase the column index.
    //Hash map to group the same colum tree nodes.
    //Update min, when we go left and update max , when we go right.
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap();
        //Using a queue, we need to add the node and the column index.
        //If we go left reduce the column index else increase.
        int min = 0;
        int max = 0;
        
        Queue<ColumnTree> queue = new LinkedList();
        queue.add(new ColumnTree(root, 0));
        
        while(!queue.isEmpty()) {
            ColumnTree current = queue.poll();
            List<Integer> list = map.getOrDefault(current.index, new ArrayList());
            list.add(current.node.val);
            map.put(current.index, list);
            
            if(current.node.left!=null) {
                min = Math.min(min, current.index -1);
                queue.add(new ColumnTree(current.node.left, current.index -1));
            }
            
            if(current.node.right!=null) {
                max = Math.max(max, current.index +1);
                queue.add(new ColumnTree(current.node.right, current.index +1));
            }
        }
        
        for(int i=min;i<=max;i++) {
            result.add(map.get(i));
        }
        
        return result;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new  VerticalOrderTraversal();
        List<List<Integer>> result = verticalOrderTraversal.verticalOrder(new TreeNode().getSample());
        System.out.println("The result: "+result);
    }
}
