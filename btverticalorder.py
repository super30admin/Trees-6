# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative - Breadth first traversal
# Time complexity - O(n logn) worst case [O(n) - visits every node, O(nlogn) - sorting]
# Space complexity - O(n) hashmap and queue
# Did this solution run on leetcode? - yes
from collections import deque

class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return
        # keep track of nodes in vertical order dictionary.
        self.verticalOrder = dict()
        
        queue = deque([(root, 0)])
        while queue:
            # pop the left most element from the queue (FIFO)
            node, level = queue.popleft()
            
            # add the node to the vertical order.
            if level not in self.verticalOrder:
                self.verticalOrder[level]=[]
            self.verticalOrder[level].append(node.val)
            
            # add the left and right children to the queue.
            if node.left:
                queue.append((node.left, level-1))
            if node.right:
                queue.append((node.right, level+1))
            
        return [self.verticalOrder[k] for k in sorted(self.verticalOrder)]


# Iterative - Breadth first traversal
# Time complexity - O(n) 
# Space complexity - O(n) hashmap and queue
# Did this solution run on leetcode? - yes (Solution from leetcode)
# Avoiding the sorting step.
# keep track of the minimum and maximum column value.
from collections import deque

class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return
        # keep track of nodes in vertical order dictionary.
        self.verticalOrder = dict()
        # minimum and maximum value for columns
        minValue = maxValue = 0
        
        # add the node to the queue.
        queue = deque([(root, 0)])
        while queue:
            # pop the left most element from the queue (FIFO)
            node, level = queue.popleft()
            
            # keep track of minimum and maximum column.
            minValue = min(minValue, level)
            maxValue = max(maxValue, level)
            
            # add the node to the vertical order.
            if level not in self.verticalOrder:
                self.verticalOrder[level]=[]
            self.verticalOrder[level].append(node.val)
            
            # add the left and right children to the queue.
            if node.left:
                queue.append((node.left, level-1))
            if node.right:
                queue.append((node.right, level+1))
            
        return [self.verticalOrder[k] for k in range(minValue, maxValue+1)]

    