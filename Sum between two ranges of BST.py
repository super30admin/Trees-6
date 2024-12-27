#Time Complexity: O(N), where N is the number of nodes in the tree, as every node is visited once.
#Space Complexity: O(H), where H is the height of the tree, due to the recursion stack.
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result=0
        def dfs(node):
            if(node==None):
                return
            if(node.val>=low and node.val<=high):
                self.result+=node.val
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return self.result 