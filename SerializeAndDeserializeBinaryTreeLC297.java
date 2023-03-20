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

    //Approach 2, here we are simply serialzing and deserialing a tree in such a manner that currentNode's left and right children is just next to the currentNode, if left and right children is null, then we add "null" while serializing, we are serializing in such a way that's why while deserializing we take the global index and maintain queue

    //Time Complexity: O(n)
    //Space Complexity: O(n)

    // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {

    //     if(root == null) return "";                                 //check if root is null, then return empty string

    //     StringBuilder result = new StringBuilder();                 //to store result string

    //     Queue<TreeNode> queue = new LinkedList<>();                 //create a queue to store node
    //     queue.add(root);                                            //add root node

    //     while(!queue.isEmpty()){                                    //iterate till queue is empty

    //         TreeNode currentNode = queue.poll();                    //poll the node from queue

    //         if(currentNode!=null){                                  //check if currentNode is null or not
    //             result.append(currentNode.val);                     //if it's not null, then add the currentNode value to the result
    //             queue.add(currentNode.left);                        //add the left and right children of the currentNode to queue
    //             queue.add(currentNode.right);
    //         }
    //         else{
    //             result.append("null");                              //if currentNode is null, them add "null" to the result
    //         }
    //         result.append(",");                                     //append , to keep seperate the different node values
    //     }
    //     return result.toString();                                   //return the result
    // }



    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {

    //     if(data == null || data.length() == 0) return null;         //check for null case

    //     String[] arr = data.split(",");                                     //split the data by ,
    //     int index = 0;                                                      //assign index to 0

    //     TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));       //create a root node and assign the value from the arr

    //     Queue<TreeNode> queue = new LinkedList<>();                         //create a queue and add the root
    //     queue.add(root);

    //     while(!queue.isEmpty() && index<arr.length){                        //iterate till queue is empty or index reaches to the length of arr

    //         TreeNode currentNode = queue.poll();                            //poll the node from queue

    //         if(!arr[index].equals("null")){                                         //check the current index element in the arr, if it's null then do nothing, if it's not null then go inside the if block

    //             currentNode.left = new TreeNode(Integer.parseInt(arr[index]));          //assign the arr's index value to the currentNode's left children, add it to the queue
    //             queue.add(currentNode.left);
    //         }
    //         index++;                                                        //increase the index

    //         if(!arr[index].equals("null")){                                             //check again if the currentIndex element in the arr is not null,

    //             currentNode.right = new TreeNode(Integer.parseInt(arr[index]));             //if it's not null then convert the value to the TreeNode and assign it to the currentNode' right children and add it to the queue
    //             queue.add(currentNode.right);
    //         }
    //         index++;                                                        //increase the index
    //     }
    //     return root;                                                       //return the root
    // }



    //Approach 1, here we are using the pre-order approach to serialize the binary tree and in the same way we are deserialing

    //Time Complexity: O(n)
    //Space Complexity: O(n)

    final String X = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null){                                       //check if root is null or not
            return X;                                           //if it's null then, return "X"
        }
        String left = serialize(root.left);                     //if it's not null, then call the recursive function on left child and store the result in left string
        String right = serialize(root.right);                  //call the recursive function on right child and store the result in right string

        return root.val+","+left+","+right;                     //return the string which concates the root.val + left and right string
    }

    // Decodes your encoded data to tree.
    String[] arr;
    int index = 0;                                              //take the index pointer globally and assign it to the 0

    public TreeNode deserialize(String data) {

        arr = data.split(",");                                  //split the data by ,
        return helper();                                        //return the output from the helper function
    }

    private TreeNode helper(){

        if(arr[index].equals("X")){                             //check if arr[index] is X which means null or not
            index++;                                            //means it's X(null), then we just have increase the index and return null
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));           //otherwise, take the arr[index] value, convert it into TreeNode and increase the index pointer
        root.left = helper();                                       //call the helper function and store the result in left child
        root.right = helper();                                      //call the helper function and store the result in right child

        return root;                                                //return the root node
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

public class SerializeAndDeserializeBinaryTreeLC297 {
}
