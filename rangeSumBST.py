class Solution:
    '''
    T = O(N)
    S = O(1)
    '''
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        
        def helper( root, low, high ):
            nonlocal sum_
            if not root:
                return 
            if root.val >= low and root.val <=high :
                sum_ += root.val
            
            helper( root.left , low, high )
            helper( root.right , low, high )
                
        sum_ = 0 
        helper(  root, low, high  )
        return sum_
    
