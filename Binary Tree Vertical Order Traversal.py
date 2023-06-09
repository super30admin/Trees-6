# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Time O(n)
        # Space O(n)
        if not root:
            return []
        res = []
        hmap = collections.defaultdict(list)
        dq = collections.deque()
        dq.append((root, 0))

        while dq:
            curr, idx = dq.popleft()
            hmap[idx].append(curr.val)
            if curr.left:
                dq.append((curr.left, idx - 1))
            if curr.right:
                dq.append((curr.right, idx + 1))
        for i in sorted(hmap.keys()):
            res.append(hmap[i])

        return res
