'''
leet code - 938. Range Sum of BST
approach = Level order traversal  BFS and dfs

'''
# BFS 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root:
            return
        q=deque()
        q.append(root)
        res=0
        while q:
            size=len(q)
            for i in range(len(q)):
                curr=q.popleft()
                if curr.left:
                    q.append(curr.left)
                if L<=curr.val<=R :
                        res+=curr.val
                if curr.right:
                    q.append(curr.right)
        return res          
                                
                    
                    
# DFS

class Solution:
    global res
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root:
            return 
        self.res=0
        return self.helper(root,L,R)
             
                    
    
    
    def helper(self, root,L, R):
        if not root:
            return 
        if root.left:
            self.helper(root.left, L,R)
        if root.right:
            self.helper(root.right, L,R)
        if L<=root.val<=R:
            self.res+=root.val
        return self.res
            