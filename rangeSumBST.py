"""
TC =0(n)
SC=0(N)

there is lot of approach to do this solution. 

This is Ierative solution- Preorder traversal

if val comes in range of low and high push into stack 


"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        sum1 = 0
        st = [root]
        while st:
            node = st.pop()
            if node:
                if low <= node.val <= high:
                    sum1 += node.val
                if node.val > low:
                    st.append(node.left)
                if node.val < high:
                    st.append(node.right)
        return sum1
    
        