# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    # for both functions
    # TC : O(n)
    # SC : O(n)
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        res = ""
        q = deque()
        q.append(root)
        while q : 
            curnode = q.popleft()
            if curnode is not None:
                res += str(curnode.val)
                q.append(curnode.left)
                q.append(curnode.right)
            else:
                res += "#"
            res += ","
        return res
            
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None

        values = data.split(",")
        root = TreeNode(int(values[0]))
        queue = collections.deque([root])
        i = 1

        while queue:
            node = queue.popleft()

            if values[i] != "#":
                leftNode = TreeNode(int(values[i]))
                node.left = leftNode
                queue.append(leftNode)
            i += 1

            if values[i] != "#":
                rightNode = TreeNode(int(values[i]))
                node.right = rightNode
                queue.append(rightNode)
            i += 1

        return root
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))