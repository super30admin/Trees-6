# Time: O(n)
# Space: O(n)
# Did it run on Leetcode: yes   

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

class Solution:
    """
    @param root: the root of tree
    @return: the vertical order traversal
    """
    def vertical_order(self, root: TreeNode) -> List[List[int]]:
        # write your code here
        res=[]
        if root is None:
            return res
        hmap={}
        q=Queue()
        colq=Queue()
        q.put(root)
        colq.put(0)
        minel,maxel=0,0
        while not q.empty():
            curr=q.get()
            currcol=colq.get()
            if(currcol not in hmap):
                hmap[currcol]=[]
            hmap[currcol].append(curr.val)
            if(curr.left is not None):
                q.put(curr.left)
                colq.put(currcol-1)
                minel=min(minel, currcol-1)
            if(curr.right is not None):
                q.put(curr.right)
                colq.put(currcol+1)
                maxel=max(maxel,currcol+1)
        for i in range(minel, maxel+1):
            res.append(hmap[i])
        return res
