# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        #Approach: Iterative DFS w/ pruning
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        
        result = 0
        st = [root]
        
        while st:
            root = st.pop()
            if not root:
                continue
                
            if low <= root.val <= high:
                result += root.val
            if root.val > low:
                st.append(root.left)
            if root.val < high:
                st.append(root.right)
                
        return result
    
    #Solution 2
    """
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        #Approach: Iterative DFS w/ pruning
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        
        result = 0
        st = []
        while st or root:
            while root:
                st.append(root)
                if root.val > low:
                    root = root.left
                else:
                    break
            
            root = st.pop()
            if low <= root.val <= high:
                result += root.val
                
            if root.val < high:
                root = root.right
            else:
                break
                
        return result
    """
    
    #Solution 3
    """
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        #Approach: Recursive DFS w/ pruning
        #Time Complexity: O(n)
        #Space Complexity: O(n)   // under the hood
        
        self.result = 0
        self.dfs(root, low, high)
        return self.result
    
    def dfs(self, root, low, high):
        #base
        if not root:
            return
        
        #logic
        if low <= root.val <= high:
            self.result += root.val
        if root.val > low:
            self.dfs(root.left, low, high)
        if root.val < high:
            self.dfs(root.right, low, high)
    """