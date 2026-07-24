// Time Complexity : O(n) where n is the total number of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Serialize - Base condition - If root is null, I return "". I add the root to the queue and perform BFS on the tree. If the node removed out of the queue is null, I append "#" to the string builder. 
Else I append the value stored by the tree node. After this I append a "," to the string builder.

Deserialize - If the length of input string is 0, I return null. I start traversing from the ith index of the string and split the string into a string array on the basis of ",". 
I add the root node to a queue and start performing BFS. For every node popped out of the queue, I set it's left child as new tree node with value present at ith index of string array. 
If value is "#", I assign a null node. Similarly I increment i and perform the same for the right child. I then add the temporary array to the queue. I perform this till no elements
remain in the queue to be processed.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder sb;

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        if(root == null)
        {
            return "";
        }

        sb = new();
        Queue<TreeNode> q = new();
        q.Enqueue(root);

        while(q.Count != 0)
        {
            TreeNode temp = q.Dequeue();
            if(temp == null)
            {
                sb.Append("#");
            }

            else
            {
                q.Enqueue(temp.left);
                q.Enqueue(temp.right);
                int val = temp.val;
                sb.Append(val.ToString());
            }

            sb.Append(",");
        }

        Console.WriteLine(sb.ToString());

        return sb.ToString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        if(data.Length == 0)
        {
            return null;
        }

        int i = 1;
        string[] stringArray = data.Split(",");
        TreeNode root = new TreeNode(int.Parse(stringArray[0]));
        Queue<TreeNode> q = new();
        q.Enqueue(root);

        while(q.Count!=0)
        {
            TreeNode temp = q.Dequeue();
            if(stringArray[i].Equals("#"))
            {
                temp.left = null;
            }

            else
            {
                temp.left = new TreeNode(int.Parse(stringArray[i]));
                q.Enqueue(temp.left);
            }

            i++;

            if(stringArray[i].Equals("#"))
            {
                temp.right = null;
            }

            else
            {
                temp.right = new TreeNode(int.Parse(stringArray[i]));
                q.Enqueue(temp.right);
            }

            i++;

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));