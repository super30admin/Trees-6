"""
https://leetcode.com/problems/binary-tree-vertical-order-traversal/
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(n)
    SC: O(n)
    """

    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root is None:
            return result
        q = collections.deque()
        minimum = float('inf')
        maximum = -float('inf')
        hashmap = {}
        q.append((root, 0))
        while q:
            curr = q.popleft()
            currnode = curr[0]
            currcol = curr[1]
            if currcol not in hashmap:
                hashmap[currcol] = []
            hashmap[currcol].append(currnode.val)

            minimum = min(minimum, currcol)
            maximum = max(maximum, currcol)
            if currnode.left != None:
                q.append((currnode.left, currcol - 1))
            if currnode.right != None:
                q.append((currnode.right, currcol + 1))

        for i in range(minimum, maximum + 1):
            result.append(hashmap[i])
        return result




