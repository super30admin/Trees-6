# Recursive Inorder
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root == None:
            return 0
        self.result = 0
        self.dfs(root, low, high)
        return self.result
    
    def dfs(self, root, low, high):
        if root == None:
            return
        if root.val >= low:
            self.dfs(root.left, low, high)
        if root.val >= low and root.val <= high:
            self.result += root.val
        if root.val <= high:
            self.dfs(root.right, low, high)   

# Iterative Inorder
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root == None:
            return 0
        stack = deque()
        result = 0
        while root != None or len(stack):
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val >= low and root.val <= high:
                result += root.val
            root = root.right
        return result      

# Iterative Preorder 
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if root == None:
            return 0
        stack = deque()
        result = 0
        stack.append(root)
        while len(stack):
            root = stack.pop()
            if root.val >= low and root.val <= high:
                result += root.val
            if root.left and root.val >= low:
                stack.append(root.left)
            if root.right and root.val <= high:
                stack.append(root.right)
        return result
            
# Time Complexity: O(n)
# Space Complexity: O(n)