class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        '''
        Time complexity: O(N + k), which is O(n) in the worst case. The BFS traversal visits each node once, and the result generation step takes O(k), where k is the range of columns. 
        Space complexity: O(N)
        '''
        if not root:
            return []

        # Create a hashmap to store vertical order traversal result
        vertical_order_map = defaultdict(list)

        # Create min_col and max_col to keep track of the range of columns
        min_col = max_col = 0

        # Create a queue for BFS traversal with tuples (node, column)
        queue = deque([(root, 0)])

        # Perform BFS traversal
        while queue:
            node, col = queue.popleft()
            # Add node value to the corresponding column
            vertical_order_map[col].append(node.val)
            min_col = min(min_col, col)
            max_col = max(max_col, col)

            if node.left:
                # Move left, decrease column index
                queue.append((node.left, col - 1))
            if node.right:
                # Move right, increase column index
                queue.append((node.right, col + 1))

        # Generate the result list using columns in the range [min_col, max_col]
        result = [vertical_order_map[col]
                  for col in range(min_col, max_col + 1)]

        return result
