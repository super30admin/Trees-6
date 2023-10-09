#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#DFS solution is complicated as it involves merge sort, we need to keep track of the depth also so BFS is better soltuion
from collections import deque
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q=deque()
        colq=deque()
        q.append(root)
        colq.append(0)
        map={}
        minVar=0
        maxVar=0
        result=[]
        while q:
            curr=q.popleft()
            currCol=colq.popleft()
            if currCol not in map.keys():
                map[currCol]=[]
            map.get(currCol).append(curr.val)
            if curr.left:
                q.append(curr.left)
                colq.append(currCol-1)
                minVar=min(minVar,currCol-1)
            if curr.right:
                q.append(curr.right)
                colq.append(currCol+1)
                maxVar=max(maxVar,currCol+1)

        for i in range(minVar,maxVar+1):
            result.append(map.get(i))

        return result