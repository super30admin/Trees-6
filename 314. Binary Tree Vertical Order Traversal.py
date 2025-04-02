#Time:O(n)
#space: O(n*n)
from collections import defaultdict, deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        dic=defaultdict(list)
        q=deque()
        mn= float('inf')
        mx= float('-inf')
        q.append([root,0])
        while len(q) != 0:
            size= len(q)
            for _ in range(size):
                curr= q.popleft()
                node=curr[0]
                dis=curr[1]
                dic[dis].append(node.val)
                mn= min(mn,dis)
                mx= max(mx,dis)
                if node.left is not None:
                    q.append([node.left,dis-1])
                if node.right is not None:
                    q.append([node.right,dis+1])
        res=[]
        for i in range(mn,mx+1):
            if i in dic:
                res.append(dic[i])
        return res
