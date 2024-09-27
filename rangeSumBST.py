class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return 0
        
        sum_ = 0
        #left
        if root.val>low:
            sum_+= self.rangeSumBST(root.left,low,high)
        #right    
        if root.val<high:
            sum_+= self.rangeSumBST(root.right,low,high)
            
        if root.val>=low and root.val<=high:
            sum_+=root.val
            
        return sum_
        
        #tc  o(n)  sc o(h).h could be n in skewed tree
