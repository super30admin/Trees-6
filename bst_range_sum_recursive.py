# // Time Complexity :O(n)-going through all nodes
# // Space Complexity :O(h)- height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def __init__(self):
        self.result=0
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.helper(root,low,high)
        return self.result
    def helper(self,root,low,high):
        #base
        if root is None:
            return
        #logic
        if root.val>=low:
            self.helper(root.left,low,high)
        if root.val>=low and root.val<=high:
            self.result+=root.val
        if root.val<=high:
            self.helper(root.right,low,high)
        