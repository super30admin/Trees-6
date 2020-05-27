'''
Solution : BFS and DFS
Time Complexity: O(N)
Space Complexity: O(N)
Did this code successfully run on Leetcode : Yes
Explanation:
Iterate through the tree and check if root.val falls in range L and R, if it does then add the value and recurse left and right
If root.val<L: this means that the left subtree is smaller than L, no use iterating the left side so go only on the right
If root.val>R: this means that the right subtree is too high so go only left
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.sum = 0

    def bfs(self, root, L, R):
        queue = [root]
        ans = 0
        while len(queue) != 0:
            root = queue[0]
            queue = queue[1:]

            if L <= root.val <= R:
                ans += root.val
                if root.left != None:
                    queue.append(root.left)
                if root.right != None:
                    queue.append(root.right)
            elif root.val < L:
                if root.right != None:
                    queue.append(root.right)
            else:
                if root.left != None:
                    queue.append(root.left)
        return ans

    # Optimised from before by now using global sum and iterating to left or right subtrees based on some condition, this makes sure we don't waste traversals
    def helper(self, root, L, R):
        if root == None:
            return 0

        if L <= root.val <= R:
            return self.helper(root.left, L, R) + root.val + self.helper(root.right, L, R)
        elif root.val < L:
            '''
            range is 12-20 so no point going left so go right
                10
            5       15
            '''
            return self.helper(root.right, L, R)
        else:
            # if root.val>R:
            return self.helper(root.left, L, R)

    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:

        # Solution 2 - Optimised (%tage imcrease 60%)
        return self.helper(root, L, R)

        # Solution 3 = BFS
        # return self.bfs(root, L, R)