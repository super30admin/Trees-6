# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Codec:
    def serialize(self, root):
        # check for null case, if so then return an empty string
        if not root:
            return ''
          
        # create an empty string to start with and append the root node to the queue
        string = ''
        q = deque([root])
        
        # traverse until the q is not empty
        while q:
            # pop the first element from the queue
            curr = q.popleft()
            
            # if the node is null, then append '#' to the string
            if curr is None:
                string += '#,'
            else:
              # otherwise append the value of the curr node and append the children of current node to the queue to process
                string += str(curr.val)
                string += ','
                q.append(curr.left)
                q.append(curr.right)
                
        # return the string with the traversal of the tree
        return string

    def deserialize(self, data):
        # check for null case, if so then return None
        if not data or len(data) == 0:
            return None
        
        # starting index is 0
        idx = 0
        
        # split the data which is comma separated to a string array
        string = data.split(",")
        
        # create the root node and append it to the queue, increment the index
        root = TreeNode(string[idx])
        q = deque([root]); idx += 1
        
        # traverse until the queue is empty or we do not reach the end of the string array
        while q and idx < len(string):
          
            # pop the element from the queue
            curr = q.popleft()
            
            # if the current index in string is not a null or '#' then we create a left child of the root node and append the node to queue
            if string[idx] != '#':
                curr.left = TreeNode(string[idx])
                q.append(curr.left)
                
            # increment the index irrespective of the node
            idx += 1
            
            # if the current index in string is not a null or '#' then we create a right child of the root node and append the node to queue
            if string[idx] != '#':
                curr.right = TreeNode(string[idx])
                q.append(curr.right)
                
            # increment the index irrespective of the node  
            idx += 1
        
        # return the root for which we have formed the whole tree
        return root
            
            
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
