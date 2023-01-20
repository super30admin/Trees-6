package s30.trees.trees6;

import s30.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {


    //DFS
    //TC: O(n)
    //SC: O(h)
    StringBuilder res;
    int index = 0;
    public String serialize(TreeNode root) {

        res = new StringBuilder();

        dfsSerialize(root);

        return res.toString();

    }

    // Decodes your encoded data to tree.
   //TC: O(n)
    // SC: O(h + n) n for split array.
    public TreeNode deserialize(String data) {

        String[] s = data.split(",");

        return deserialize(s);

    }



    private TreeNode deserialize(String[] data){

        //base
        if(data[index].equals("n")) return null;


        //recurse
        TreeNode node = new TreeNode(Integer.parseInt(data[index]));

        index++;
        node.left = deserialize(data);

        index++;
        node.right = deserialize(data);


        return node;
    }

    private void dfsSerialize(TreeNode node){


        if(res.length()!=0) res.append(",");
        //base
        if(node == null){
            res.append("n");
            return;
        }

        //recurse

        res.append(node.val);

        dfsSerialize(node.left);
        dfsSerialize(node.right);

    }



    //BFS
    //TC: O(n)
    //SC: O(n)
    public String serializeBFS(TreeNode root) {

        StringBuilder res = new StringBuilder();

        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(res.length() != 0){
                res.append(",");
            }

            if(node != null){
                res.append(node.val);

                q.add(node.left);
                q.add(node.right);
            }
            else res.append("n");
        }

        return res.toString();

    }

    // Decodes your encoded data to tree.
    //TC: O(n)
    //SC: O(n)
    public TreeNode deserializeBFS(String data) {

        String[] s = data.split(",");

        Queue<TreeNode> q = new LinkedList();

        if(data.equals("n")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        q.add(root);

        int index = 1;

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(!s[index].equals("n")){
                node.left = new TreeNode(Integer.parseInt(s[index]));
                q.add(node.left);
            }

            index++;

            if(!s[index].equals("n")){
                node.right = new TreeNode(Integer.parseInt(s[index]));
                q.add(node.right);
            }

            index++;
        }


        return root;

    }

    public static void main(String[] args) {

    }
}
