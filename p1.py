#Time: O(n)
#Space: O(N)

class Solution:
    def dfs(self, root : TreeNode, l : int, r : int):
        #base
        if not root: 
            return
       
        if root.val >= l and root.val <= r: 
            self.res += root.val
        if root.val > l: 
            self.dfs(root.left, l, r)
        if root.val < r:
            self.dfs(root.right, l, r)

    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.res = 0
        self.dfs(root, L, R)
        return self.res
