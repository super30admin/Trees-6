# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Codec:
    #Approach: BFS
    #Time Complexity: O(n)
    #Space Complexity: O(n)
    #where, n is the size of the tree
    
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        
        sb = []
        de = deque([root])
        
        while de:
            root = de.popleft()
            if root:
                sb.append(str(root.val))
                
                de.append(root.left)
                de.append(root.right)
            
            else:
                sb.append('None')
                
        return ','.join(sb)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        
        if not data:
            return None
        
        data = data.split(',')
        head = TreeNode(data[0])
        
        de = deque([head])
        
        idx = 0     #'used up' elements in data
        while de:
            root = de.popleft()
            
            if data[idx + 1] != 'None':
                root.left = TreeNode(data[idx + 1])
                de.append(root.left)
            if data[idx + 2] != 'None':
                root.right = TreeNode(data[idx + 2])
                de.append(root.right)
            idx += 2
            
        return head

'''
class Codec:
    #Approach: DFS
    #Time Complexity: O(n)
    #Space Complexity: O(n)
    #where, n is the size of the tree
    
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        sb = []
        def helper(root):
            if not root:
                sb.append('None')
            else:
                sb.append(str(root.val))
                helper(root.left)
                helper(root.right)
        
        helper(root)
        return ','.join(sb)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data = data.split(',')
        idx = 0
        def helper(data):
            nonlocal idx
            if data[idx] == 'None':
                idx += 1
                return None
            
            root = TreeNode(data[idx])
            idx += 1
            root.left = helper(data)
            root.right = helper(data)
            return root
            
        return helper(data)
'''

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))