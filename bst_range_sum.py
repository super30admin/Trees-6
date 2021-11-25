# // Time Complexity :O(n)-going through all nodes
# // Space Complexity :O(h)- height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



#o(n)-process every node,o(h)- height of stack
#iiterative preorder traversal
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def __init__(self):
    #     self.result=0
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        st=[]
        result=0
        st.append(root)
        while st:
            root=st.pop() 
            if root.val>=low and root.val<=high:
                result+=root.val
            if root.val< high and root.right:
                st.append(root.right)
            if root.val>low and root.left:
                st.append(root.left)
        return result