# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import deque, TreeNode
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return ""
        
        sb = ""
        q = deque()
        q.append(root)
        while q:
            curr = q.popleft()
            if curr != None:
                sb+=str(curr.val)
                q.append(curr.left)
                q.append(curr.right)
            else:
                sb+='#'
            sb+=' '
        
        return sb        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 0:
            return None
        
        strArr = data.split(" ")
        q = deque()
        idx = 0
        root = TreeNode(int(strArr[idx]))
        q.append(root)
        idx+=1
        while q and idx != len(strArr):
            curr = q.popleft()
            #left
            if strArr[idx] != '#':
                curr.left = TreeNode(int(strArr[idx]))
                q.append(curr.left)
            idx+=1
            #right
            if strArr[idx] != '#':
                curr.right = TreeNode(int(strArr[idx]))
                q.append(curr.right)
            idx+=1
        
        return root

        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))