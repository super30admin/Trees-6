# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
      
        # declare default values for res and check for null case of root
        res = []
        if not root:
            return res
        
        # creating hashmap to store the cols and it's corresponding nodes at that col number
        hashmap = {}
        
        # add the root and the col in two different queues
        q = deque([root])
        cols = deque([0])
        
        # find min and max to traverse over the cols in hashmap
        min_val, max_val = 0,0
        
        # traverse until the q is not empty
        while q:
          
            # pop from both the queues
            curr = q.popleft()
            col = cols.popleft()
            
            # if the col value is not in hashmap, then make an entry with empty list, then add the current node to that key
            if col not in hashmap:
                hashmap[col] = []
            hashmap[col].append(curr.val)
            
            # if we have a left node, then append the node to the q and also update the cols queue with curr col value - 1
            if curr.left:
                q.append(curr.left); cols.append(col - 1)
                min_val = min(min_val, col - 1)
            
            # if we have a right node, then append the node to the q and also update the cols queue with curr cols value + 1
            if curr.right:
                q.append(curr.right); cols.append(col + 1)
                max_val = max(max_val, col + 1)
        
        # traverse over the min to max value from hashmap and keep appending to the res list
        for i in range(min_val, max_val + 1):
            res.append(hashmap[i])
        
        # return the res which is the list of lists
        return res
