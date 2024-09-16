package problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();
		int minCol = 0;
		int maxCol = 0;

		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			Pair curr = queue.poll();

			if (!map.containsKey(curr.col)) {
				map.put(curr.col, new ArrayList<>());
			}
			map.get(curr.col).add(curr.node.val);

			if (curr.node.left != null) {
				queue.add(new Pair(curr.node.left, curr.col - 1));
				if (curr.col - 1 < minCol) {
					minCol = curr.col - 1;
				}
			}

			if (curr.node.right != null) {
				queue.add(new Pair(curr.node.right, curr.col + 1));
				if (curr.col + 1 > maxCol) {
					maxCol = curr.col + 1;
				}
			}
		}

		for (int col = minCol; col <= maxCol; col++) {
			ans.add(map.get(col));
		}

		return ans;
	}

	private void print(List<List<Integer>> cols) {
		for (List<Integer> col : cols) {
			for (Integer element : col) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		VerticalOrderTraversal obj = new VerticalOrderTraversal();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		List<List<Integer>> verticalOrderTraversal = obj.verticalOrder(root);
		System.out.println("Vertical order traversal: ");
		obj.print(verticalOrderTraversal);
	}

}
