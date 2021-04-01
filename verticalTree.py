# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        #can store tuples as well
        res = []
        if not root:
            return res
        
        hm = {}

        queue = deque([])
        cols = deque([])
        queue.append(root)
        cols.append(0)
        mn = mx = 0
        
        while queue:
            curr = queue.popleft()
            col = cols.popleft()
            
            mn = min(mn, col)
            mx = max(mx, col)
            if col not in hm:
                hm[col] = []
            
            hm[col].append(curr.val)
            
            if curr.left:
                queue.append(curr.left)
                cols.append(col - 1)
                
            if curr.right:
                queue.append(curr.right)
                cols.append(col + 1)
                
        for i in range(mn,mx+1):
            res.append(hm[i])
            
        return res