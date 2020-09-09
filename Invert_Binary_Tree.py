// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
used BFS in this approach.
we travel level by level and for every node if we find left and right nodes for the given node then we reverse them and add them to the queue.

# BFS 
# Time complexity --> o(n)
# space complexity --> o(n)
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root==None:
            return root
        queue=deque([root])
        while len(queue)!=0:
            node=queue.popleft()
            #Invert the left and right side of a node.
            node.left,node.right=node.right,node.left
            if node.left!=None:
                queue.append(node.left)
            if node.right!=None:
                queue.append(node.right)
        return root
 // Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
           
# DFS approach
# Time complexity --> o(n)
# space complexity --> o(height of the tree)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root==None:
            return None
        left=self.invertTree(root.left)
        right=self.invertTree(root.right)
        #make the left side of the tree to the right and vice versa.
        root.right=left
        root.left=right
        return root
        
        
        