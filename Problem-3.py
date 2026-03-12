# Time Complexity : O(N)  # Each node is processed once
# Space Complexity : O(N) # Queue and hashmap to store columns
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

# Explanation:
# Perform BFS traversal while tracking column index of each node.
# Root starts at column 0.
# Left child -> column - 1
# Right child -> column + 1
# Store nodes in hashmap based on column index.
# Finally return values from minimum column to maximum column.

from collections import defaultdict, deque

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        col_map = defaultdict(list)
        queue = deque([(root, 0)])
        
        min_col = max_col = 0
        
        while queue:
            node, col = queue.popleft()
            
            col_map[col].append(node.val)
            
            min_col = min(min_col, col)
            max_col = max(max_col, col)
            
            if node.left:
                queue.append((node.left, col - 1))
            
            if node.right:
                queue.append((node.right, col + 1))
        
        res = []
        for c in range(min_col, max_col + 1):
            res.append(col_map[c])
        
        return res