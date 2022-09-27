'''
Time Complexity: 0(n) -- end up touching all the nodes
Space Complexity: 0(h) --- height of tree
Run on LeetCode: Yes
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from collections import OrderedDict

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # base-case
        if root == None:
            return []
        
        # initialize dict
        ordDict = OrderedDict()
        
        # initialize queue
        queue = deque()
        
        # add root to the queue
        queue.append((0,root))
        
        # maintain lvl
        lvl = 0
        
        # maintain min and max for bucket sort
        minima = 0
        maxima = 0
        
        # iterate the queue
        while len(queue)!=0:
            
            # maintain size
            size = len(queue)
            
            for count in range(0,size):
                
                # pop the element from the queue
                tuplePair = queue.popleft()

                # add the key-value pair to the ordDict
                if tuplePair[0] not in ordDict:
                    ordDict[tuplePair[0]] = [tuplePair[1].val]
                else:
                    ordDict[tuplePair[0]].append(tuplePair[1].val)

                # add the children to the queue
                if tuplePair[1].left != None:
                    queue.append((tuplePair[0]-1,tuplePair[1].left))
                    minima = min(minima,tuplePair[0]-1)
                
                if tuplePair[1].right != None:
                    queue.append((tuplePair[0]+1,tuplePair[1].right))
                    maxima = max(maxima,tuplePair[0]+1)
                    
            '''end of for loop'''
            
            # update lvl
            lvl += 1
        
        '''end of while loop'''
        
        lvl -= 1
        
        # print(ordDict)
        
        # return result
        result = []
        
        for i in range(minima,maxima+1):
            result.append(ordDict[i])
        
        # print(result)
        return result   
        
        
        