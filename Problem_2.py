"""
Time Complexity : O(n) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        queue = deque()
        queue.append(root)
        result = []
        
        while queue:
            curr = queue.popleft()
            if curr != None:
                result.append(str(curr.val))
                result.append(",")
                queue.append(curr.left)
                queue.append(curr.right)
            else:
                result.append("null")
                result.append(",")
        return "".join(result)          
            
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data or len(data) == 0:
            return None
        arr = data.split(',')
        root = TreeNode(int(arr[0]))
        queue = deque()
        queue.append(root)
        i = 1
        
        while queue and i < len(arr):
            curr = queue.popleft()
            if arr[i] != "null":
                left = TreeNode(arr[i])
                curr.left = left
                queue.append(left)
            i += 1
            if arr[i] != "null":
                right = TreeNode(arr[i])
                curr.right = right
                queue.append(right)
            i += 1
        return root
            
