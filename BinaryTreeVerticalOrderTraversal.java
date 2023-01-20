package s30.trees.trees6;

import s30.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Algo: find the leftmost value of the tree, then perform a  BFS to maintain the order.

//TC : O(n)
//SC: O(n) for queue
public class BinaryTreeVerticalOrderTraversal {


    List<List<Integer>> res;
    int idRoot;
    public List<List<Integer>> verticalOrder(TreeNode root) {

        res = new ArrayList();

        if(root == null) return res;

        idRoot = 0;

        leftWidth(null, root, 0);

        idRoot = -1 * idRoot;

        for(int i=0; i <= idRoot; i++){
            res.add(new ArrayList());
        }

        Queue<Pair> q = new LinkedList();

        q.add(new Pair(root, idRoot));


        while(!q.isEmpty()){
            Queue<Pair> next = new LinkedList();

            while(!q.isEmpty()){
                Pair p = q.poll();

                TreeNode node = p.node;
                int id = p.id;

                if(id > res.size() -1) res.add(new ArrayList());

                res.get(id).add(node.val);

                if(node.left!= null) next.add(new Pair(node.left, id - 1));
                if(node.right!= null) next.add(new Pair(node.right, id + 1));

            }

            q = next;
        }


        return res;
    }

    class Pair{
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }

    private void leftWidth(TreeNode par, TreeNode node, int width){


        //base
        if(node == null) return;


        if(par != null && par.left == node){
            --width;
        }
        else if(par!= null && par.right == node){
            ++width;
        }

        idRoot = Math.min(idRoot, width);

        leftWidth(node, node.left, width);
        leftWidth(node, node.right, width);

    }
    public static void main(String[] args) {

    }
}
