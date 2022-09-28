# Time complexity: O(n)
# Space complexity: O(h)-recursive stack space
# Approach: do any traversal-inorder/preorder/postorder
# since its bst, check if the node val is lesser than high before moving to root.right
# check if the node val is higher than low before moving to root.left
# while adding the node val, check if it lies in the range low and high
# have used inorder traversal in the code
class Solution:
    def __init__(self):
        self.sum = 0
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root == None:
            return 0
        self.dfs(root,low, high)
        return self.sum
    def dfs(self, root, low, high):
        if root == None:
            return
        if root.val >= low:
            self.dfs(root.left, low, high)
        if root.val <= high and root.val >= low:
            self.sum = self.sum + root.val
        if root.val <=high:
            self.dfs(root.right, low, high)
        