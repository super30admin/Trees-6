# Definition for a binary tree node.
# from typing import collections
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# class Codec:

#     def serialize(self, root):
#         if not root : return '#'
#         res = []
#         q = collections.deque([root])
#         while q:
#             curr = q.popleft()
#             if curr:
#                 res.append(str(curr.val))
#                 q.append(curr.left)
#                 q.append(curr.right)
#             else:
#                 res.append('#')
#         return ','.join(res)

#     def deserialize(self, data):
#         if data is None or data=='#': return None
#         idx = 0
#         splitarr = data.split(',')
#         root = TreeNode(int(splitarr[idx]))
#         q = collections.deque([root])
#         idx+=1
#         while q:
#             curr = q.popleft()
#             if splitarr[idx]!='#':
#                 curr.left  = TreeNode(int(splitarr[idx]))
#                 q.append(curr.left)
#             idx+=1
#             if splitarr[idx]!= '#':
#                 curr.right = TreeNode(int(splitarr[idx]))
#                 q.append(curr.right)
#             idx+=1
#         return root

# Preorder

class Codec:

    def serialize(self, root):
        if not root : return "#"
        res = []
        self.dfsserialize(root,res)
        return ",".join(res)
    
    def dfsserialize(self,root, res):
        if not root : 
            res.append("#") 
            return 
        # logic
        res.append(str(root.val))
        self.dfsserialize(root.left, res)
        self.dfsserialize(root.right, res)

    def deserialize(self, data):
        if data is None:
            return None
        splitArr = data.split(",")
        self.idx = 0
        return self.dfsDeserialize(splitArr)

    def dfsDeserialize(self, splitArr):
        if self.idx >= len(splitArr): return None
        val = splitArr[self.idx]
        self.idx += 1
        if val == "#":
            return None
        root = TreeNode(int(val))
        root.left = self.dfsDeserialize(splitArr)
        root.right = self.dfsDeserialize(splitArr)
        return root