## Problem2: Vertical order tree traversal https://leetcode.com/problems/binary-tree-vertical-order-traversal/
# 3 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.d = {}
        if not root:
            return None
        def bfs_n_dfs(root, col, h):
            # print(self.d)
            if not root:
                return
            if col not in self.d:
                self.d[col] = [[h, root.val]]
            else:
                self.d[col].append([h, root.val])
            if root.left:
                bfs_n_dfs(root.left, col - 1, h + 1)
            if root.right:
                bfs_n_dfs(root.right, col + 1, h + 1)
    
        bfs_n_dfs(root, 0, 0)
        i = min(self.d.keys())
        j = max(self.d.keys())
        res = []
        for k in range(i, j+1):
            self.d[k].sort()
            d1 = [a[1] for a in self.d[k]]
            # d1.sort()
            res.append(d1)
        
        # print(self.d)
        return res