// Time Complexity : O(n)
// Space Complexity : O(n) to store vertical traversal map and both the queues
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
If root is null I return an empty result. I create a vertical traversal map which has the column identifier as the key and List<int> as values. I also create a queue of type tree node which I use
for BFS and a column queue to store all corresponding column indices. At first I set column index to 0 and push the index to column queue and root node to tree node queue. I start performing BFS, 
while processing each node present in the queue, I add the value of the node to the list present in vertical traversal map whose key is the corresponding column index. Then for all the left children,
I set corresponding column index as parent node column index - 1 and for each right child, I set corresponding column index as parent node column index + 1. 
I add the corresponding node and column index to the respective queues and perform BFS until all nodes are not visited. 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<IList<int>> VerticalOrder(TreeNode root) {
        List<IList<int>> result = new();
        
        if(root == null)
        {
            return result;
        }

        Dictionary<int, List<int>> verticalTraversalMap = new();
        Queue<TreeNode> q = new();
        Queue<int> columnQ = new();

        q.Enqueue(root);
        columnQ.Enqueue(0);
        int min = 0, max = 0;

        while(q.Count != 0)
        {
            TreeNode temp = q.Dequeue();
            int column = columnQ.Dequeue();

            if(!verticalTraversalMap.ContainsKey(column))
            {
                verticalTraversalMap[column] = new();
            }

            verticalTraversalMap[column].Add(temp.val);

            if(temp.left != null)
            {
                q.Enqueue(temp.left);
                columnQ.Enqueue(column - 1);
                min = Math.Min(min, column - 1);
            }

            if(temp.right != null)
            {
                q.Enqueue(temp.right);
                columnQ.Enqueue(column + 1);
                max = Math.Max(max, column + 1);
            }
        }

        for(int i = min; i<=max; i++)
        {
            result.Add(verticalTraversalMap[i]);
        }

        return result;
    }
}