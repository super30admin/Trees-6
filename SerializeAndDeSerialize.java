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

    //Time Complexity: 0(n) where n is the no. of nodes for both serialization and de serialization
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No
    //In brief Explain your approach:

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>(); //queue for bfs traversal
        StringBuilder sb = new StringBuilder(); //stringbuilder to store the string value of the node and to serialize the tree

        q.add(root);    //adding root to the queue for processing

        while(!q.isEmpty()){
            TreeNode curr = q.poll();   //removing the element from the queue
            if(curr == null){   //check if the element removed is null or not. (i have to add the null children of the nodes as well
                sb.append("null");  //add null to my string
                sb.append(','); //add a comma. The problem statement demands the pattern
                continue;   //continue because I wont be adding children's of null because it will be null and I will go into infinite loop.
            }
            sb.append(curr.val);    //if it is not null, I am adding the string value of the current node
            sb.append(','); //adding the comma
            q.add(curr.left);   //adding the left child to the queue for further processing
            q.add(curr.right);  //adding the right child to the queue for further processing
        }
        return sb.toString();   //returning the string
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }

        String[] array = data.split(",");   //Since the input data is in form of string and I have to convert it into a tree, I need to sepatate the string based on comma
        Queue<TreeNode> q = new LinkedList<>(); //queue to do a bfs
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));   //creating a tree root and adding the 1st string to the root

        q.add(root);    //adding root to the queue for processing
        int i = 1;  //to traverse over the string. Starting from 1 as I have already added the 1st element to the queue and tree

        while(i < array.length){    //till I traverse the end of the string
            TreeNode curr = q.poll();   //getting the current node in the tree
            if(!array[i].equals("null")){   //adding left child to the node
                curr.left = new TreeNode(Integer.parseInt(array[i]));   //getting the ith element and adding it to the tree.
                q.add(curr.left);   //adding that element to further process it's child
            }
            i++;    //increasing i outside the if because the current string might be a null, so I won't add it to the tree, but I will need to move to the next string
            if(!array[i].equals("null")){   //adding ith string to the right child
                curr.right = new TreeNode(Integer.parseInt(array[i]));
                q.add(curr.right);  //adding it to the queue for further processing.
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