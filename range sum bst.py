"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
when we get val which is greater than low and lower than high, we add to sum
we can control the recursion. If we found the node is lesser tahn low
we can not further recurse on left side of tree. same for high.


"""

class Solution1:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root == None: return 0
        stack = []
        sm = 0
        stack.append(root)
        
        while stack or root:
            while root:
                if root.left.val>=low:
                    root = root.left
                    stack.append(root)
                else:
                    break
            print(root.val)   
            root = stack.pop()
            if root.val >= low and root.val<=high:
                    sm += root.val
            if root.val<=high:
                root = root.right
        return sm
                
        
        
        
class Solution:
    def __init__(self):
        self.sm = 0
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root == None: return 0
        
        def bst(root):
            if root:
                
                if root.val >= low and root.val<=high:
                    self.sm += root.val
                if root.val>=low:
                    bst(root.left)
                if root.val<=high:
                    bst(root.right)
        bst(root)
        return self.sm
        