// Time Complexity : O(n) : Traverse through each node and assign the level 
// Space Complexity : O(n) :
// Worst case : Complete binary tree Leaf nodes - BFS queue. O( n/2) and 
// Skew tree in hashmap results in O(n)

class Solution {
	
	class Pair{

		TreeNode node;
		int level; 
	}


	public List<List<Integer>> verticalOrder(TreeNode root){


		if (root == null){
			return new ArrayList<>();
		}
		// map the node to the level of the column
		HashMap < Integer, List<Integer>> map = new HashMap<>();

		// queue 
		Queue <Pair> queue = new LinkedList<>();

		Pair pair = new Pair();
		pair.node = root;
		pair.level = 0;

		// Add the root into the queue
		queue.add(root);

		// To sort the nodes in the tree as per the levels
		int minLevel = 0;
		int maxLevel = 0;

		while (!queue.isEmpty()){

			// poll the tree node
			Pair curr = new Pair();

			// update the hashmap with node and level
			if (! map.containsKey(curr.level)){
				map.put(curr.level, new ArrayList<>());
			}

			// update the value to the node
			map.get(curr.level).add(curr.node.val);


			if (curr.node.left != null){

				// add the left child of the root into the queue
				Pair pair = new Pair();
				pair.node = curr.node.left;
				pair.level = curr.level - 1;

				queue.add(pair);

				// minimum will not change as per the level. It should be the min of all the levels
				min = Math.min(min, pair.level);
			} 

			if (curr.node.right != null){
                // add the right child of the root into the queue
				Pair pair = new Pair();
				pair.node = curr.node.right;
				pair.level = curr.level + 1;

				queue.add(pair);


				// maximum will not change as per the level. It should be the max of all the levels
				max = Math.max(max, pair.level);

			}

		}

		List<List<Integer>> result =  new ArrayList<>();

		// min and max level will help to create the result in sorted manner.
		for (int i = min; i < max ; i++){
			result.add(map.get(i));
		}
	}
}