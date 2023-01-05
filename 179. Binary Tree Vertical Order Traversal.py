from typing import (
    List,
)
from lintcode import (
    TreeNode,
)

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
from collections import deque


class Solution:
    """
    @param root: the root of tree
    @return: the vertical order traversal
    """

    def vertical_order(self, root: TreeNode) -> List[List[int]]:
        # write your code here
        result = []
        if root is None:
            return result
            # node  column
        q = deque()
        cols = deque()
        q.append(root)
        cols.append(0)
        hashMap = dict()
        minimum = float("inf")
        maximum = float("-inf")

        while q:
            curr = q.popleft()
            col = cols.popleft()
            minimum = min(minimum, col)
            maximum = max(maximum, col)

            if col not in hashMap.keys():
                hashMap[col] = []
            hashMap.get(col).append(curr.val)

            if curr.left != None:
                q.append(curr.left)
                cols.append(col - 1)

            if curr.right != None:
                q.append(curr.right)
                cols.append(col + 1)

        for i in range(minimum, maximum + 1):
            result.append(hashMap.get(i))
        return result

# BFS
# Time Complexity: O(nlogn)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No