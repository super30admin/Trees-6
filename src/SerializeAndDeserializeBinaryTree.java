import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public String serialize(TreeNode root) {
        String serial = "";
        if (root == null) return serial;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            if (temp == null) {
                serial += '#';
                serial += ',';
                continue;
            }
            serial += String.valueOf(temp.val);
            serial += ',';
            que.add(temp.left);
            que.add(temp.right);
        }
        StringBuilder sb = new StringBuilder(serial);
        sb.deleteCharAt(serial.length() - 1);
        System.out.println("Serialized: " + sb.toString());
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        que.add(root);
        i = 1;

        while (!que.isEmpty() && i < arr.length) {
            TreeNode temp = que.poll();

            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode templ = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = templ;
                que.add(templ);
            }
            i++;

            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode tempr = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = tempr;
                que.add(tempr);
            }
            i++;
        }
        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        /*     1
              / \
             2   3
                / \
               4   5
         */

        String serialized = codec.serialize(root);
        TreeNode deserializedRoot = codec.deserialize(serialized);

        System.out.print("In-order of deserialized tree: ");
        codec.inorder(deserializedRoot);
    }
}

