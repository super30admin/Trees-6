/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * class Solution {
 * int res;
 * * // Tc: O(n) Sc: O(n)
 * public int rangeSumBST(TreeNode root, int low, int high) {
 * if (root == null)
 * return res;
 * inorder(root, low, high);
 * return res;
 * }
 * 
 * private void inorder(TreeNode root, int low, int high) {
 * if (root == null)
 * return;
 * inorder(root.left, low, high);
 * if (root.val >= low && root.val <= high) {
 * res += root.val;
 * }
 * inorder(root.right, low, high);
 * }
 * }
 * 
 */

/*
 * class Solution {
 * public int rangeSumBST(TreeNode root, int low, int high) {
 * // Tc: O(n) Sc: O(n)
 * 
 * Queue<TreeNode> q = new LinkedList<>();
 * q.add(root);
 * int res = 0;
 * while (!q.isEmpty()) {
 * TreeNode cur = q.poll();
 * if (cur.val >= low && cur.val <= high) {
 * res += cur.val;
 * }
 * 
 * if (cur.val >= low) {
 * if (cur.left != null)
 * q.add(cur.left);
 * }
 * if (cur.right != null)
 * q.add(cur.right);
 * }
 * return res;
 * }
 * }
 * 
 */