# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

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
        res = []
        if not root:
            return res
        queue = deque([root])
        while queue:
            curr = queue.popleft()
            if curr is not None:
                res.append(str(curr.val))
                res.append(',')
                queue.append(curr.left)
                queue.append(curr.right)
            else:
                res.append('null')
                res.append(',')
        return ''.join(res)
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        arr = data.split(',')
        i = 0
        root = TreeNode(arr[0])
        queue = deque([root])
        i += 1
        while queue and i < len(arr)-1:
            curr = queue.popleft()
            
            #left child
            if arr[i]:
                curr.left = TreeNode(arr[i])
                queue.append(curr.left)
            i += 1
            if arr[i]:
                curr.right = TreeNode(arr[i])
                queue.append(curr.right)
            i += 1
            
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))