# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        q = deque()
        q.append(root)
        result = 0
        while q:
            curr = q.popleft()
            if low <= curr.val <= high:
                result += curr.val
            if curr.left: q.append(curr.left)
            if curr.right: q.append(curr.right)
        return result

        