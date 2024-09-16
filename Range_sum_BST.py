Approach -1:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we have used BFS approach to solve this problem.
from root we go level by level and check if the element in a level is in between L and R.If yes we add it to the result.
Time complexity --> o(n)
space complexity --> o(n)
# BFS
from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rangeSumBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        if root==None:
            return 0
        res=0
        queue=deque([root])
        while len(queue)!=0:
            node=queue.popleft()
            if L<=node.val<=R:
                res=res+node.val
            if node.left!=None:
                queue.append(node.left)
            if node.right!=None:
                queue.append(node.right)
        return res
        
Approach 2:

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we start from the root.
As it is BST,If the root value is less than L then we traverse the right side of the tree.
If the root value is greater than the right side of the tree then we traverse the left side of the tree.

Time complexity --> o(n)
space compexity --> o(h) --> height of the tree.
# DFS
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rangeSumBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        if root==None:
            return 0
        #As it a BST if the root value is less than L then we traverse the right side of the tree.
        if root.val<L:
            return self.rangeSumBST(root.right,L,R)
        #If the root value is greater than BST then we traverse the left side of the tree.
        elif root.val >R:
            return self.rangeSumBST(root.left,L,R)
        return root.val+self.rangeSumBST(root.left,L,R)+self.rangeSumBST(root.right,L,R)
        
        