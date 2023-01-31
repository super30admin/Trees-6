# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ## T.C = O(n)
        ## S.C = O(n)

        if not root:
            return []
        hm = collections.defaultdict(list)
        res = []
        mn = float('inf')
        mx = float('-inf')

        q = [[0, root]]

        while q:
            lbl, node = q.pop(0)
            mn = min(mn, lbl)
            mx = max(mx, lbl)
            hm[lbl].append(node.val)

            if node.left is not None:
                q.append([lbl - 1, node.left])
            if node.right is not None:
                q.append([lbl + 1, node.right])
        
        for i in range(mn, mx+1):
            res.append(hm[i])

        return res