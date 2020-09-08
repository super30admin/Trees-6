"""
time : o(n)
space : o(n)

"""
from collections import deque
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
            return ""
        
        s = ""
        
        q = deque()
        q.append(root)
        
        while q: #iterating over the tree using queue
            cur = q.popleft()
            if cur:
                s = s + str(cur.val)
                s = s + ","
                
                q.append(cur.left)
                q.append(cur.right)
                
            else: #if null, add null to the string
                s = s + "null"
                s = s + ","
                 
        return s

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        #print(data)
        if not data:
            return None
        vals = data.split(",") #split the string at , 
        i = 0
        root = TreeNode(vals[i]) #create root node
        
        q = deque()
        
        q.append(root)
        i += 1 #position in the input string, will always be at the children of the current node
        while q and i < len(vals):
            cur = q.popleft()
            
            if vals[i] != "null":
                cur.left = TreeNode(vals[i])
                q.append(cur.left)
            i += 1 #if at null, simply increment the ptr
            
            if vals[i] != "null":
                cur.right = TreeNode(vals[i])
                q.append(cur.right)
            i += 1

        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))