'''
Time Complexity: 0(n) 
Space Complexity: 0(n)
Run on LeetCode: Yes
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        # initialize queue
        queue = deque([])
        
        # add root to the queue
        queue.append(root)
        
        # initialize lvl
        lvl = 0
        
        # return the string
        result = []
        
        # iterate the queue
        while len(queue)!= 0:
            
            # initialize size
            size = len(queue)
            
            # iterate the queue
            for count in range(0,size):
                
                # pop the node from the queue
                node = queue.popleft()
                
                # add the value to the result
                if node == None:
                    result.append(node)
                else:
                    result.append(node.val)
                
                # add left and right child to the queue
                if node != None:
                    queue.append(node.left)
                    queue.append(node.right)
            '''end of for loop'''
            
            # update lvl
            lvl += 1
        '''end of while loop'''
        
        # update the lvl
        lvl -= 1
        
        # using list comprehension
        listToStr = ' '.join(map(str, result))
        # print('Result is:\t',listToStr)
        
        return listToStr
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        # convert data string to list
        data = data.split(' ')
        
        # base case
        if data == ['None']:
            return []
        
         #   initializations
        queue = deque([])
        root = TreeNode(data[0])
        queue.append(root)
        cursor = 1

        #   iterate until the queue is empty
        while (len(queue) > 0):

            #   remove the front node
            currentNode = queue.popleft()

            #   add its corresponding left node
            if cursor < len(data) and (data[cursor] != 'None'):
                currentNode.left = TreeNode(data[cursor])
                queue.append(currentNode.left)
            cursor += 1

            #   add its corresponding right node
            if cursor < len(data) and (data[cursor] != 'None'):
                currentNode.right = TreeNode(data[cursor])
                queue.append(currentNode.right)
            cursor += 1

        #   return root node
        return root
    
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))