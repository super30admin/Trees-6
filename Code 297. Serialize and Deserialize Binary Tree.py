from collections import defaultdict
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
        #bfs to add to string
        q=deque()
        q.append(root)
        s=''
        while q:
            size=len(q)
            for _ in range(size):
                curr=q.popleft()
                if curr:
                    q.append(curr.left)
                    q.append(curr.right)
                    s+=str(curr.val)
                else:
                    s+='null'
                s+=','
        return s        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data=data.split(',')
        if data[0]=='null':
            return []
        q= deque()
        root=TreeNode(int(data[0]))
        q.append(root)
        i=1
        while i < len(data) and q:
            curr= q.popleft()
            if data[i] !='null':
                node=TreeNode(int(data[i]))
                curr.left=node
                q.append(node)
            i+=1
            if data[i] !='null':
                node=TreeNode(int(data[i]))
                curr.right=node
                q.append(node)
            i+=1
        return root  

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
