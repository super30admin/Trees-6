# Trees-6

## Problem1: Sum between two ranges of BST(https://leetcode.com/problems/range-sum-of-bst)

# Time Complexity = O(n)
# Space Complexity = O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        sumi=0
        def helper(node):
            nonlocal sumi
            if node is None:
                return 0
            if node.val>=low:
                helper(node.left)
            if node.val<=high:
                helper(node.right)
            if node.val>=low and node.val<=high:
                sumi+=node.val
            return sumi
        return helper(root)
                
        

## Problem2: Serialize and Deserialize Binary Tree (https://leetcode.com/problems/serialize-and-deserialize-binary-tree)


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
        
        s=[]
        q=deque()
        q.append(root)
        while q:
            curr=q.popleft()
            if curr is None:
                s.append("null")
            else:
                s.append(str(curr.val))
            if curr is not None:
                q.append(curr.left)
                q.append(curr.right)
        return ",".join(s)
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data is None:
            return []
        i=0
        k=data.split(',')
        q=deque()
        if k[0]=='null':
            return 
        root=TreeNode(int(k[0]))
        q.append(root)
        i+=1
        while q and i<len(k)-1:
            curr=q.popleft()
            if curr is not None:
                if k[i]!='null':
                    curr.left=TreeNode(int(k[i]))
                q.append(curr.left)
                i+=1
                if k[i]!='null':
                    curr.right=TreeNode(int(k[i]))
                q.append(curr.right)
                i+=1
        return root
            
        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))

