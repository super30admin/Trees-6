// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) Queue for both
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: For serialize, do a level by level traversal and store each root value in a 
String Builder appending with a comma to separate. For deserialise, store the node in the queue so that we cna keep track of next left and right child.
As you fetch out of the queue, create the node and attach the node as the left and right child alongwith iterating over the string array.
*/
public String serialize(TreeNode root) {
    if(root == null) return "";
    StringBuilder sb = new StringBuilder();                                                             // Serialise into string
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        if(curr != null) {
            sb.append(curr.val).append(",");                                                        // If not null, add root val and comma
             q.add(curr.left);
            q.add(curr.right);                                                                  // Explore next nodes
        }
        else sb.append("null").append(",");                                                         // Add null to the string
    }
    return sb.toString();
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if(data == null || data.length() == 0) return null;                                                         // Base case
    String[] tree = data.split(",");
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode root1 = new TreeNode(Integer.parseInt(tree[0]));                                                           // Root node create
    q.add(root1);
    int i  = 1;
    while(!q.isEmpty() && i < tree.length){
        TreeNode curr = q.poll();                                                                               // Node to be explored
        if(!tree[i].equals("null"))
        {               
            TreeNode nodeL = new TreeNode(Integer.parseInt(tree[i]));                               // Add the node to the left child
            curr.left = nodeL;
            q.add(nodeL);                                                                               // Node to be explored next
        }   
        i++;
        if(!tree[i].equals("null"))
        {            
            TreeNode nodeR = new TreeNode(Integer.parseInt(tree[i]));                                           // Add node to the right child
            curr.right = nodeR;                                                                             // Node to be explored next
            q.add(nodeR);
        }
        i++;
    }
    return root1;                                                                                           // Tree is ready
}
}