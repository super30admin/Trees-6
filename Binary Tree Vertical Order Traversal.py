# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    #Solution 1
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        #Approach: BFS
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the size of the tree
        
        if not root:
            return []
        
        colMap = defaultdict(list)
        
        de = deque()
        de.append((root, 0))
        minCol = maxCol = 0
        
        while de:
            root, col = de.popleft()
            colMap[col].append(root.val)
            minCol = min(minCol, col)
            maxCol = max(maxCol, col)
            
            if root.left:
                de.append((root.left, col - 1))
            if root.right:
                de.append((root.right, col + 1))
                
        result = []
        for i in range(minCol, maxCol + 1):
            result.append(colMap[i])
            
        return result
    
    #Solution 2
    """
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
    """