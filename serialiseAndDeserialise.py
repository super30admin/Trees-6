# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#time: O(n)
#Space: O(N)
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        st = self.serial(root,'')
        print(st)
        
        return st
        
    def serial(self, root, st):
        if root == None:
            st += 'None,' 
        else:
            st += str(root.val) + ','
            st = self.serial(root.left, st)
            st = self.serial(root.right, st)
            
        return st

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """            
        data = data.split(',')
        root  = self.deserial(data)
        
        return root
    
    def deserial(self, data):
        if data[0] == 'None':
            data.pop(0)
            return None

        r = TreeNode(data[0]) 
        data.pop(0)
        r.left = self.deserial(data)
        r.right = self.deserial(data)
        
        return r

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))