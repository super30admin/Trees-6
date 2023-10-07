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

        # Time O(N)
        # Space O(N)
        # # BFS Approach
        # res = []
        # dq = collections.deque()
        # dq.append(root)

        # while dq:
        #     curr = dq.popleft()
        #     if not curr:
        #         res.append('null')
        #         continue
        #     res.append(str(curr.val))
        #     dq.append(curr.left)
        #     dq.append(curr.right)
        # # print(res)
        # return ','.join(res)

        # DFS Approach
        if not root:
            return ''
        s = []
        def dfs(root):
            if not root:
                s.append('null')
                return 
            # Preorder traversal using dfs
            s.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        # print(s)
        return ','.join(s)


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        # Time O(N)
        # Space O(N)
        # # BFS APPROACH
        # data = data.split(',')
        # # print(data)
        # if not data or data[0] == 'null': return None
        # dq = deque()
        
        # i = 0
        # root = TreeNode(int(data[i]))
        # dq.append(root)
        # i += 1
        # while dq:
        #     curr = dq.popleft()
        #     if data[i] != 'null':
        #         curr.left = TreeNode(int(data[i]))
        #         dq.append(curr.left)
        #     i += 1
        #     if data[i] != 'null':
        #         curr.right = TreeNode(int(data[i]))
        #         dq.append(curr.right)
        #     i += 1
        # return root

        # DFS Approach
        global i
        s = data.split(',')
        # print(s)
        if not data or s[0] == 'null': return None 
        i = 0
        def dfs():
            global i
            if s[i] == 'null':
                i += 1
                return None
            # print(s[i])
            node = TreeNode(int(s[i]))
            i += 1
            node.left = dfs()
            node.right = dfs()
            return node
        return dfs()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
