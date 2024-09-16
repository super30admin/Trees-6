# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(N)

#Space Complexity: O(N) 

from collections import deque
from collections import defaultdict
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        mini = 0
        maxi = 0
        queue = deque()
        queue.append((root,0))
        hmap = defaultdict(list)
        
        while(queue):
            sz = len(queue)
            for i in range(sz):
                node,ind = queue.popleft()
                hmap[ind].append(node.val)
                mini = min(mini,ind)
                maxi = max(maxi,ind)
                if node.left:
                    queue.append((node.left,ind-1))
                if node.right:
                    queue.append((node.right,ind+1))
                
        for i in range(mini,maxi+1):
            res.append(hmap[i])
        return res