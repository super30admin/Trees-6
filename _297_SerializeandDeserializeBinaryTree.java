// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Serialise the preorder with nulls
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return  sb.toString().substring(0, sb.length()-1);
    }

    public void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("n,");
            return;
        }
        sb.append(root.val+",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        String[] preorder = data.split(",");
        return construct(preorder);
    }

    public TreeNode construct(String[] preorder){

        if(preorder[index].equals("n")){
            index++;
            return null;
        }

        TreeNode curr = new TreeNode(Integer.parseInt(preorder[index]));
        index++;
        curr.left = construct(preorder);
        curr.right = construct(preorder);
        return curr;
    }
}

/****************** level order traversal approach*************/
// add nulls in levele order but dont add child of null nodes, when deserialize then also use queue nad levele order traverala
// poll the current element inext element in array will will be left child and next to that will be right child

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){

            TreeNode curr = q.poll();

            if(curr == null){
                sb.append("n,");
                continue;
            }
            else{
                sb.append(curr.val+",");
            }
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        if(data.equals("n")) return null;
        String[] levelorder = data.split(",");
        return construct(levelorder);
    }

    public TreeNode construct(String[] levelorder){
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(levelorder[0]));
        index++;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!levelorder[index].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(levelorder[index]));
                q.add(left);
                curr.left = left;
            }
            index++;

            if(!levelorder[index].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(levelorder[index]));
                q.add(right);
                curr.right = right;
            }
            index++;
        }

        return root;
    }
}
