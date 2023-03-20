public class VericalOrderTreeTraversalLC314 {

    //Binary Tree Vericle Order Traversal
    //Problem: https://www.lintcode.com/problem/651/

    //Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(n)

    Map<Integer, List<Integer>> map;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here

        map = new HashMap<>();                                      //create a hashmap to store the node values and keeps seperate nodes on column basis

        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();                     //here we are applying bfs to thats we have created queue
        Queue<Integer> columns = new LinkedList<>();                 //this queue is used to store columns

        int min = 0;                                                //here we are applying bucket sort at the end, so we need to find the min and max range for that so thats why we created min and max variables
        int max = 0;

        q.add(root);                                                //add root in the queue
        columns.add(0);                                             //lets assume root is column zero, so add in the columns queue

        while(!q.isEmpty()){                                        //iterate till queue is isEmpty

            TreeNode node = q.poll();                               //poll node from the queue
            int col = columns.poll();                               //poll col from the columns

            if(!map.containsKey(col)){                            //check if there are any previous nodes present in the map
                map.put(col, new ArrayList());                    //if not, then add that column in map
            }
            map.get(col).add(node.val);                           //get the column value and add current node value to that column list

            if(node.left != null){                                  //check if node's left children null or not
                q.add(node.left);                                   //if it's not null, then add left chhildren to the queue
                columns.add(col -1);                                //add the col-1 to the columns queue
                min = Math.min(min, col-1);                         //update the min value
            }
            if(node.right != null){                                 //check if node's right children is null or not
                q.add(node.right);                                  //if it's not null, then add right children to the queue
                columns.add(col+1);                                 //add col + 1 to the columns queue
                max = Math.max(max, col+1);                         //update the max value
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = min; i<=max; i++){                              //iterate from min to max
            result.add(map.get(i));                                 //get the value from map and add it to the result
        }
        return result;
    }



    //Approach 1
    //Time Complexity: O(n) + we have used TreeMap so sorting Complexity is added to time Complexity
    //Space Complexity: O(n)


    // Map<Integer, List<Integer>> map;

    // public List<List<Integer>> verticalOrder(TreeNode root) {
    //     // write your code here
    //     map = new TreeMap<>();
    //     List<List<Integer>> result = new ArrayList<>();

    //     if(root == null) return result;

    //     Queue<TreeNode> q = new LinkedList<>();
    //     Queue<Integer> levels = new LinkedList<>();

    //     q.add(root);
    //     levels.add(0);

    //     while(!q.isEmpty()){

    //         TreeNode node = q.poll();
    //         int level = levels.poll();

    //         if(!map.containsKey(level)){
    //             map.put(level, new ArrayList());
    //         }
    //         map.get(level).add(node.val);

    //         if(node.left != null){
    //             q.add(node.left);
    //             levels.add(level -1);
    //         }
    //         if(node.right != null){
    //             q.add(node.right);
    //             levels.add(level+1);
    //         }
    //     }

    //     for(int key: map.keySet()){
    //         result.add(map.get(key));
    //     }
    //     return result;
    // }

}
