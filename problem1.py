#Time O(n), space O(h)
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        
        return self.help(root,low,high)
  
#Helper for calculating sum
    def help(self,root,low,high):
        
        sum=0
        if root is None:
            return 0
 #For left subtree       
        if root.val>=low:
            sum=self.help(root.left,low,high)
 #For right subtree           
        if root.val<=high:
            sum+=self.help(root.right,low,high)
 #For root           
        if root.val>=low and root.val<=high:
            sum+=root.val
            
        return sum
