"""
Time Complexity : O(n) 
Space Complexity : O(n) hasmap and queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from collections import defaultdict


class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        hashmap = defaultdict(list)
        minimum, maximum = 0, 0
        q = deque()
        q.append(((root, 0, 0)))
        while q:
            node, r, c = q.popleft()
            if node:
                hashmap[c].append((r, node.val))
                minimum = min(minimum, c)
                maximum = max(maximum, c)
                q.append((node.left, r + 1, c - 1))
                q.append((node.right, r + 1, c + 1))
        result = []
        for col in range(minimum, maximum + 1):
            result.append([val for r, val in sorted(hashmap[col])])

        return result
