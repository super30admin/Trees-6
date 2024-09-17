# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        que = deque()
        col = deque()
        result = []
        que.append(root)
        col.append(0)
        dic = {}
        mini, maxi = 0,0
        while (que):
            t = que.popleft()
            c = col.popleft()
            
            if (c not in dic):
                dic[c] = []
            
            dic[c].append(t.val)
            
            if t.left != None:
                que.append(t.left)
                col.append(c-1)
                mini = min(c-1,mini)
                
            if t.right != None:
                que.append(t.right)
                col.append(c+1)
                maxi = max(c+1,maxi)
                
        print(dic, mini, maxi)   
        for i in range(mini, maxi+1):
            result.append(dic[i])
            
        return result