"""
1. Imagine a grid with x and y coordinates, we can then get the vertical order of tree by either doing a dfs or bfs.
2. We use bfs as the rows are in order, we use a hashmap to keep track of the column currently in.
3. We keep track of the min and max column to avoid sorting the hashmap at the end.

TC: O(n)
SC: O(n) -> queue 
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
            
        columns = defaultdict(list)
        min_col, max_col = 0, 0
        queue = deque([(root, 0)])

        while queue:
            node, column = queue.popleft()

            if node is not None:
                columns[column].append(node.val)

                min_col = min(min_col, column)
                max_col = max(max_col, column)

                queue.append((node.left, column - 1))
                queue.append((node.right, column + 1))
            
        return [columns[x] for x in range(min_col, max_col + 1)]
        




            




        



            




        