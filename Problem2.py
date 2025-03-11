# Problem 2
# Serialize and Deserialize Binary Tree (https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        if not root: return ""
        sb = []
        q = deque([root])

        while q:
            curr = q.popleft()
            if curr:
                sb.append(str(curr.val))
                q.append(curr.left)
                q.append(curr.right)
            else:
                sb.append("#")

        return ",".join(sb)

    def deserialize(self, data):
        if not data: return None
        nodes = data.split(",")
        root = TreeNode(int(nodes[0]))
        q = deque([root])
        idx = 1

        while q:
            curr = q.popleft()
            if nodes[idx] != "#":
                curr.left = TreeNode(int(nodes[idx]))
                q.append(curr.left)
            idx += 1
            if nodes[idx] != "#":
                curr.right = TreeNode(int(nodes[idx]))
                q.append(curr.right)
            idx += 1
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))