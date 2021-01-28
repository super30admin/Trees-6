#In this problem we use DFS and add the result to sum variable only if it lies in the range
#Time Complexity: O(h)
#Space complexity: O(1)
class Solution:
    def __init__(self):
        self.result = 0
        
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return result
        self.dfs(root,low,high)
        return self.result
    
    def dfs(self, root, low, high):
        if root is None:
            return
        if root.val >= low and root.val <= high:
            self.result +=root.val
        self.dfs(root.left,low,high)
        self.dfs(root.right,low,high)