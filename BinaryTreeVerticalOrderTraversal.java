import java.util.*;

public class Main {

    //Time Complexity: 0(n) where n is the no. of nodes
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: No, I don't have leetcode premium
    //Did you face any problem while coding: No
    //In brief Explain your approach:

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>(); //queue to carry out bfs traversal
        Queue<Integer> column = new LinkedList<>(); //to store the columns. I am stating that I am denoting root as 0, If i traverse left, I do -1, and if i traverse right, I do a +1. This way I can vertically order my tree
        HashMap<Integer, List<Integer>> map = new HashMap<>();  //HashMap to store the column no. and the value of the nodes falling in that column
        List<List<Integer>> result = new ArrayList<>(); //to return the final result
        int min = Integer.MAX_VALUE;    //as I am using a hashmap so order of key is not set. I need to return my answer in ascending order, So my min keeps a track of my 1st column and max my last column
        int max = Integer.MIN_VALUE;

        q.add(root);    //adding root to my queue for processing
        column.add(0);  //as mentioned above, I am ordering root as column 0

        while(!q.isEmpty()){
            TreeNode curr = q.poll();   //getting the current node
            int col = column.poll();    //getting the column value
            min = Math.min(min, col);   //setting min and max columns
            max = Math.max(max, col);
            if(!map.containsKey(col)){  //if my map does not contain the column as key, I am adding column and creting a new arraylist to store the values of treenode falling in that column
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(curr.left != null){  //traversing and checking if there are elements in the left or not
                q.add(curr.left);   //if yes, then adding it to my queue
                column.add(col - 1);//also decreasing the value of column
            }
            if(curr.right != null){ //doing same for the right
                q.add(curr.right);
                column.add(col + 1);
            }
        }
        for(int i = min; i <= max; i++){    //going over my hashmap from min to max and storing it to my result
            List<Integer> list = map.get(i);
            result.add(list);
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        t = new TreeNode(20);
        t.left = new TreeNode(8);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(12);
        t.left.right.left = new TreeNode(10);
        t.left.right.right = new TreeNode(14);
        List<List<Integer>> abc = verticalOrder(t);
        System.out.println(Arrays.asList(abc));
    }
}