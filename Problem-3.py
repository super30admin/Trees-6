#Approach
#Do the level order traversal if it gone left level is -1  if its right +1

#Complexities
#Time: O(n)
#Space:(o(n)


#Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def verticalOrderBST(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result = []
        levelMap = dict()
        queue = []
        queue.append((root,0))
        minlevel = float("inf")
        maxlevel = float("-inf")
        while queue:
            node, level = queue.pop(0)
            if level not in levelMap:
                levelMap[level ] = []
                minlevel = min(minlevel, level )
                maxlevel = max(maxlevel, level )
            levelMap[level].append(node.val)
            if node.left:
                queue.append((node.left,level-1))
            if node.right:
                queue.append((node.right,level+1))

        for i in range(minlevel,maxlevel+1):
            result.append(levelMap[i])



        return result

root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

solution = Solution()
print(solution.verticalOrderBST(root))