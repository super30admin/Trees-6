"""
Use Serialize and deserialize same method 
Used BFS for both 

TC and SC  O(N)


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
        q = deque()
        q.append(root)
        res = []
        while q:
            curr = q.popleft()
            if curr:
                res.append(str(curr.val))
                res.append(",")
                q.append(curr.left)
                q.append(curr.right)
            else: #If curr node is null, push child as Null
                res.append("null")
                res.append(",")
        return ''.join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        strArr = data.split(',')
        root = TreeNode(int(strArr[0]))
        q = deque()
        q.append(root)
        i = 1
        while q and i < len(strArr):
            curr = q.popleft()
            if strArr[i] != 'null': #i is the index of left child
                left = TreeNode(strArr[i])
                curr.left = left
                q.append(left)
            i += 1
            if i < len(strArr) and strArr[i] != 'null':
                right = TreeNode(strArr[i])
                curr.right = right
                q.append(right)
            i += 1
        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))