#Time complexity : O(n)
#Space complexity: O(h) where h is the height of BST for the recursion stack 
#Works on leetcode : yes
#Approach : We use a recursive solution where we return the sum of root's value and 2 recursive calls to left and right children
#However before that, we check if need to return the rangeSum of any of the left and right children of the root. We do this to 
#cut down the computation time and since if the root is more than R, we need to look in root's left. Also if the root is 
#less than L, we need to look in root's right
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        
        if not root:
            return 0
        if root.val > R:
            return self.rangeSumBST(root.left, L,R)
        if root.val < L:
            return self.rangeSumBST(root.right, L, R)
        return root.val + self.rangeSumBST(root.left, L,R) + self.rangeSumBST(root.right, L,R)
                