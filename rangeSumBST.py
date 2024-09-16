# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def controlledDFS(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0
        total = 0
        if low<=root.val<=high:
            total += root.val
        if root.val<high:
            total += self.rangeSumBST(root.right, low, high)
        if root.val>low:
            total += self.rangeSumBST(root.left, low, high)
        
        return total

    def breadthFirstSearch(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0
        
        queue = deque([root])
        output = 0
        while queue:
            curr = queue.popleft()
            if low<=curr.val<=high:
                output+=curr.val
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)
        
        return output

    def inOrder(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0
        
        stack = []
        output = 0
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            if low<=root.val<=high:
                output+=root.val
            root = root.right
        return output

# Time Complexity : O(N)
# Space: O(N)
        
        
