#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""
        q=deque()
        q.append(root)
        result=""
        while q:
            curr=q.popleft()
            if curr!=None:
                result+=str(curr.val)
                q.append(curr.left)
                q.append(curr.right)
            else:
                result+='#'
            result+=','    
        return result


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data)==0:
            return None
        splitArr=data.split(',')
        idx=1
        root=TreeNode(int(splitArr[0]))
        q=deque()
        q.append(root)
        while idx<len(splitArr) and q:
            curr=q.popleft()
            if splitArr[idx]!='#':
                curr.left=TreeNode(int(splitArr[idx]))
                q.append(curr.left)
            idx+=1

            if splitArr[idx]!='#':
                curr.right=TreeNode(int(splitArr[idx]))
                q.append(curr.right)
            idx+=1
        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))