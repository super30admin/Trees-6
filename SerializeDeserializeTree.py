# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#All TC passed on leetcode


class Codec:

    #Using BFS approach. We traverse the tree starting root and push children  into queue. Each poped queue element appednded to output string.
    #time complexity - O(n)
    #space complexity - O(n)
    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str"""
        if not root:
            return ""
        s = ""
        q = collections.deque()
        q.append(root)

        while q:
            cur = q.popleft()
            if cur:
                s = s + str(cur.val)
                q.append(cur.left)
                q.append(cur.right)
            else:
                s = s + "#"
            if q:
                s = s + ","

        return s
        
    #Using BFS approach. We traverse the data string and push non null values into queue. Each poped queue element is assigned its left and right children based on i position.
    #time complexity - O(n)
    #space complexity - O(n)
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode"""
        if not data:
            return None 
        s = data.split(",")
        i = 0

        q = collections.deque()
        root = TreeNode(s[i])
        q.append(root)
        i+=1

        while q and i<len(s):
            cur = q.popleft()
            if s[i]!="#":
                cur.left = TreeNode(int(s[i]))
                q.append(cur.left)
            i+=1

            if s[i]!="#":
                cur.right = TreeNode(int(s[i]))
                q.append(cur.right)
            i+=1

        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))