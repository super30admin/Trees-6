import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// We do a level order traversal while tracking each node’s width.
// We use a map to group all node values by their width levels from left to right.
// Finally, we gather the result by fetching values from the leftmost width to the rightmost.
// Time Complexity: O(n)
// Space Complexity: O(h)

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root){
    List<List<Integer>> result = new ArrayList<>();
    if(root==null) return result;
    HashMap<Integer,List<Integer>> hm = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> widthQ = new LinkedList<>();
    q.add(root);
    widthQ.add(0);
    int min = 0;max=0;

    while(!q.isEmpty())
    {
        TreeNode node = q.poll();
        Integer width = widthQ.poll();
        
            hm.putIfAbsent(width, new ArrayList<>());
            hm.get(width).add(node.val);
        if(node.left!=null)
        {
            widthQ.add(width-1);
            q.add(node.left);
            min = Math.min(min, width-1);
        }
        if(node.right!=null)
        {
            widthQ.add(width+1);
            q.add(node.right);
            max = Math.max(max, width+1);
        }
    }

    //bucket sort
    for(int i=min;i<=max;i++)
    {
        result.add(hm.get(i));
    }

    return result;
}
}
