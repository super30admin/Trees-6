import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Time Complexity: O(N), N is the number of nodes in the given tree
Space Complexity: O(N), N is the number of nodes in the stack
Any difficulties: No
Run on leetcode: Yes

Approach:
1. Serialize the given TreeNode using recursion
2. For deserialize reconstruct the tree with respect to the given string
 */
public class SerializeAndDeserializeBT {
    public static String rserialize(TreeNode root, String str) {
        // Recursively serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // serializing the TreeNode
    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    public static TreeNode rdeserialize(List<String> list) {
        // Recursively deserialization.
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }
    // Deserializing serialized Tree
    public static TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(dataArr));
        return rdeserialize(data_list);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("serialize: "+ serialize(root));
    }
}
