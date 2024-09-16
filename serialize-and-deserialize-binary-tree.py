# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''

TC: O(n)
SC: O(n)

'''

from collections import deque

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        
        q = deque()
        res = ""
        q.append(root)
    
        while q:
            top = q.popleft()
            res += str(top.val) if top else "null"
            res += ","
            
            if not top:
                continue
                
            q.append(top.left)
            q.append(top.right)
            
        return res[:-1]
            
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return
        
        arr = data.split(",")
        root = TreeNode(int(arr[0]))
        queue = deque()
        queue.append(root)
        idx = 1
        
        while queue and idx < len(arr):
            node = queue.popleft()
            
            if arr[idx] != "null":
                curr = TreeNode(arr[idx])
                queue.append(curr)
                node.left = curr
            idx += 1
            
            if arr[idx] != "null":
                curr = TreeNode(arr[idx])
                queue.append(curr)
                node.right = curr
            
            idx += 1
        
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))