# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Time Complexity : serialize - O(n) [n = number of nodes in Tree], deserialize - O(n) [n = number of elements in comma separated list] 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from collections import deque
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:return []
        res = []
        q = deque([root])
        res = [str(root.val)]
        while q:
            curr = q.popleft()
            if curr.left:
                res.append(str(curr.left.val))
                q.append(curr.left)
            else:
                res.append('null')
                
            if curr.right:
                res.append(str(curr.right.val))
                q.append(curr.right)
            else:
                res.append('null')
            
        return ",".join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:return None
        data = data.split(',')
        root = TreeNode(data[0])
        q = deque([root])
        i = 1
        while q and i<len(data):
            curr = q.popleft()
            if i<len(data) and data[i] != 'null':
                node = TreeNode(data[i])
                curr.left = node
                q.append(curr.left)
            i+=1
            
            if i<len(data) and  data[i] != 'null':
                node = TreeNode(data[i])
                curr.right = node
                q.append(curr.right)
            i+=1
        return root
        
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))