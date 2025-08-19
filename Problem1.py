"""
Time Complexity: O(n)
Space Complexity: O(n)
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
        
        colMap = defaultdict(list)
        queue = deque([(root, 0)])
        minCol, maxCol = 0, 0

        while queue:
            node, col = queue.popleft()
            colMap[col].append(node.val)

            minCol = min(minCol, col)
            maxCol = max(maxCol, col)

            if node.left:
                queue.append((node.left, col-1))
            if node.right:
                queue.append((node.right, col+1))
        
        result = []
        for i in range(minCol, maxCol+1):
            result.append(colMap[i])
        return result