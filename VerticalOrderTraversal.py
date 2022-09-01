# BFS variant using Queue
# TC: O(n)
# SC: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        q, idx = deque(), deque()
        q.append(root)
        idx.append(0)
        result = []
        h = {}
        minn = float("inf")
        maxx = float("-inf")
        while q:
            curr, tmp = q.popleft(), idx.popleft()
            if not curr:
                continue
            if tmp not in h.keys():
                h[tmp] = []
            h[tmp].append(curr.val)
            minn = min(minn, tmp)
            maxx = max(maxx, tmp)
            if curr.left:
                q.append(curr.left)
                idx.append(tmp - 1)
            if curr.right:
                q.append(curr.right)
                idx.append(tmp + 1)
        for i in range(minn, maxx+1):
            if i in h.keys():
                result.append(h[i])
        return result
        