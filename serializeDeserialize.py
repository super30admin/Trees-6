"""TC - O(N)
SC - O(N)"""
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
            cur = q.popleft()
            if cur:
                res.append(str(cur.val))
                res.append(",")
                q.append(cur.left)
                q.append(cur.right)
            else:
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
        while q and i <len(strArr):
            cur = q.popleft()
            if strArr[i]!='null': # i is the index of left child
                left = TreeNode(strArr[i])
                cur.left = left
                q.append(left)
                
            i+=1
                
            if i<len(strArr) and strArr[i] != 'null':
                right = TreeNode(strArr[i])
                cur.right = right
                q.append(right)
            i+=1
        return root
                
                
            
            
        
        
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))