# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#Time complexity: O(n)
#Space complexity: O(n)
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res=[]
        q=deque()
        if not root:
            return ""
        q.append(root)
        while q:
            curr=q.popleft()
            if not curr:
                res.append("null")
            else:
                res.append(str(curr.val))
            if curr:
                q.append(curr.left)
                q.append(curr.right)   
        return ",".join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        i=0
        data=data.split(',')
        q=deque()
        node=TreeNode(data[0])
        q.append(node)
        while q and i<len(data):
            curr=q.popleft()
            i+=1
            if i<len(data):
                curr.left=TreeNode(data[i])
                if curr.left:
                    q.append(curr.left)
                i+=1
                if i< len(data):
                    curr.right=TreeNode(data[i])
                    if curr.right:
                        q.append(curr.right)
        return node
            
            
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))