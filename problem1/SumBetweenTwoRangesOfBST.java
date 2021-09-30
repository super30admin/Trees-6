// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n), n -> Size of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.Stack;

public class SumBetweenTwoRangesOfBST {
	int sum;

	/********************* Recursive Solution *********************/
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		sum = 0;
		inorder(root, low, high);
		return sum;
	}

	public void inorder(TreeNode root, int low, int high) {
		// Base
		if (root == null) {
			return;
		}

		// Logic
		if (root.val >= low) {
			inorder(root.left, low, high);
		}

		if (root.val >= low && root.val <= high) {
			sum += root.val;
		}

		if (root.val <= high) {
			inorder(root.right, low, high);
		}
	}

	/********************* Iterative Inorder *********************/
	public int rangeSumBSTIterative(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		sum = 0;
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();

			if (root.val >= low && root.val <= high) {
				sum += root.val;
			}

			root = root.right;
		}

		return sum;
	}

	/********************* Iterative Inorder *********************/
	public int rangeSumBSTIterativePreorder(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		sum = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			if (root.val >= low && root.val <= high) {
				sum += root.val;
			}

			if (root.left != null && root.val >= low) {
				stack.push(root.left);
			}

			if (root.right != null && root.val <= high) {
				stack.push(root.right);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		SumBetweenTwoRangesOfBST obj = new SumBetweenTwoRangesOfBST();

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		int low = 7;
		int high = 15;

		System.out.println(
				"Sum of all nodes between \'" + low + "\' and \'" + high + "\' = " + obj.rangeSumBST(root, low, high));
	}

}
