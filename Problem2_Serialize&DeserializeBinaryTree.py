# Time Complexity: O(n), where n - number of nodes for serialize and length of the str for deserialize
# Space Complexity: O(n)

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root: TreeNode) -> str:
        """
        Encodes a tree to a single string.
        """
        if not root:
            return ""

        q = deque()
        q.append(root)
        string = ""
        while q:
            curr = q.popleft()
            if curr:
                string += str(curr.val) + ','
                q.append(curr.left)
                q.append(curr.right)
            else:
                string += 'None,'

        return string

    def deserialize(self, data: str) -> TreeNode:
        """
        Decodes your encoded data to tree.
        """
        if data == "":
            return None

        string = data.split(',')
        root = TreeNode(string[0])
        q = deque()
        q.append(root)

        i = 1
        while q and i < len(string):
            curr = q.popleft()

            # left node
            if string[i] != 'None':
                curr.left = TreeNode(string[i])
                q.append(curr.left)
            i += 1

            # right node
            if string[i] != 'None':
                curr.right = TreeNode(string[i])
                q.append(curr.right)
            i += 1

        return root
