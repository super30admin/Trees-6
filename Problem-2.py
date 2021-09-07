"""
TC: O(n)
SC: O(n)
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
            return root
        
        result = self.serialize_helper(root, '')
        print(result)
        return result
    
    def serialize_helper(self, root, array):
        if not root:
            array =  array + 'Null,'
        else:
            array += str(root.val) + ','
            array = self.serialize_helper(root.left  ,array)
            array = self.serialize_helper(root.right ,array)
        return array
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return data
        d = data.split(',')
        root = self.deserialize_helper(d)
        return root
    
    def deserialize_helper(self, data):
        #print(data)
        if data[0] == 'Null':
            data.pop(0)
            return
        
        root = TreeNode(data.pop(0))
        root.left = self.deserialize_helper(data)
        root.right = self.deserialize_helper(data)
        return root
        
        
        
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))