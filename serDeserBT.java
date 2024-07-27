/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
 * public class Codec {
 * 
 * // Encodes a tree to a single string.
 * public String serialize(TreeNode root) {
 * //Tc: O(n) Sc: O(n)
 * if (root == null) return "null";
 * StringBuilder res = new StringBuilder();
 * Queue<TreeNode> q = new LinkedList<>();
 * q.add(root);
 * while (!q.isEmpty()) {
 * TreeNode cur = q.poll();
 * if (cur != null) {
 * res.append(cur.val).append(",");
 * q.add(cur.left);
 * q.add(cur.right);
 * } else {
 * res.append("null,");
 * }
 * }
 * return res.toString().substring(0, res.length() - 1);
 * }
 * 
 * 
 * public TreeNode deserialize(String data) {
 * Tc: O(n) Sc: O(n)
 * if (data.equals("null")) return null;
 * String[] strArr = data.split(",");
 * TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
 * Queue<TreeNode> q = new LinkedList<>();
 * q.add(root);
 * int i = 1;
 * while (!q.isEmpty() && i < strArr.length) {
 * TreeNode cur = q.poll();
 * if (!strArr[i].equals("null")) {
 * cur.left = new TreeNode(Integer.parseInt(strArr[i]));
 * q.add(cur.left);
 * }
 * i++;
 * if (i < strArr.length && !strArr[i].equals("null")) {
 * cur.right = new TreeNode(Integer.parseInt(strArr[i]));
 * q.add(cur.right);
 * }
 * i++;
 * }
 * return root;
 * }
 * }
 * 
 * // Your Codec object will be instantiated and called as such:
 * // Codec ser = new Codec();
 * // Codec deser = new Codec();
 * // TreeNode ans = deser.deserialize(ser.serialize(root));
 * 
 */