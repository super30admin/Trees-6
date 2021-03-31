# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        #Approach: DFS
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the size of the tree
        
        self.colNodes = [None for i in range(200)]
        self.dfs(root, 0, 0)
        
        result = []
        for col in self.colNodes:
            if col:
                vals = []
                for level in col:
                    if level:
                        vals.extend(level)
                result.append(vals)
                    
        return result
    
    def dfs(self, root, col, level):
        #base
        if not root:
            return
        
        #logic
        if not self.colNodes[col + 100]:
            self.colNodes[col + 100] = [None for i in range(200)]
        if not self.colNodes[col + 100][level]:
            self.colNodes[col + 100][level] = []
        self.colNodes[col + 100][level].append(root.val)
        
        self.dfs(root.left, col - 1, level + 1)
        self.dfs(root.right, col + 1, level + 1)