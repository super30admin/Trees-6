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
    String res;
    StringBuilder sb;
    Queue<TreeNode> myQueue;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()){
            TreeNode curr = myQueue.poll();

            if(curr != null){
                sb.append(curr.val);
                myQueue.add(curr.left);
                myQueue.add(curr.right);
            }
            else{
                sb.append("#");
            }
            sb.append(',');
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] splitArr = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(splitArr[index]));
        index++;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()){
            TreeNode curr = myQueue.poll();
            //left
            if(!splitArr[index].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(splitArr[index]));
                myQueue.add(curr.left);
            }
            else{
                curr.left = null;
            }
            index++;

            //right
            if(!splitArr[index].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(splitArr[index]));
                myQueue.add(curr.right);
            }
            else{
                curr.right = null;
            }
            index++;
        }
        return root;
    }
}


/*
 * Time Complexity:  O(n) where n is the number of nodes
* Space Complexity: O(2*n) ~ O(n),n for iterating, another for storing string
 */
