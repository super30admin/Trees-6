# Definition for a binary tree node.
from typing import Optional,List,collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root : return []
        columnmap = collections.defaultdict(list)
        minval,maxval = 0,0
        q = collections.deque()
        q.append((root,0))
        res = []
        while q:
            curr,col = q.popleft()
            columnmap[col].append(curr.val)
            minval = min(minval,col)
            maxval = max(maxval,col)
            if curr.left:
                q.append((curr.left,col-1))
            if curr.right:
                q.append((curr.right,col+1))
        for i in range(minval, maxval+1):
            res.append(columnmap[i])
        return res
        