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
        ## T.C = O(n)
        ## S.C = O(n)

        if not root:
            return ''

        res = []
        q = [root]

        while q:
            node = q.pop(0)
            if node is None:
                res.append(str(None))
                continue
            else:
                res.append(str(node.val))
            
            q.append(node.left)
            q.append(node.right)
        
        res = ','.join(res)
        return res
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        ## T.C = O(n)
        ## S.C = O(n)
        
        if not data:
            return None

        nodes = data.split(',')
        root = TreeNode(int(nodes[0]))
        q = [root]
        i = 1
        
        while q:
            node = q.pop(0)
            if nodes[i] != 'None':
                node.left = TreeNode(int(nodes[i]))
                q.append(node.left)
            i += 1

            if nodes[i] != 'None':
                node.right = TreeNode(int(nodes[i]))
                q.append(node.right)
            i += 1

        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))