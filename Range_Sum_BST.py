#Time:O(n)
#Space:O(height)
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        global sum_val
        self.sum_val = 0
        def sum_tree(root):
            if root == None:
                return
            if root.val>=low and root.val<=high:
                sum_tree(root.left)
                sum_tree(root.right)
                self.sum_val+=root.val
            if root.val>high:
                sum_tree(root.left)
            if root.val<low:
                sum_tree(root.right)
        sum_tree(root)
        return self.sum_val