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
        sb = []
        q = deque()
        q.append(root)
        while q:
            curr = q.popleft()
            if curr:
                sb.append(str(curr.val))
                q.append(curr.left)
                q.append(curr.right)
            else:
                 sb.append('#')
        return ','.join(sb)

        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data or data == '#':
            return None
        strArr = data.split(',')
        rootVal = int(strArr[0])
        root = TreeNode(rootVal)
        q = deque()
        q.append(root)
        i = 1
        while q:
            curr = q.popleft()
            #make the left child
            if i < len(strArr) and strArr[i] != '#':
                curr.left = TreeNode(int(strArr[i]))
                q.append(curr.left)
            i += 1

            if i< len(strArr) and strArr[i] != '#':
                curr.right = TreeNode(int(strArr[i]))
                q.append(curr.right)
            i += 1

            #make the right child
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))