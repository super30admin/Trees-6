
'''
using BFS
'''
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:

        # Using queue and BFS

        queue = deque()

        result =0

        queue.append(root)

        while(queue):

            curr_node = queue.popleft()

            curr_val = curr_node.val

            if(curr_val >= low and curr_val<=high):
                result+=curr_val

            if(curr_node.left):
                queue.append(curr_node.left)

            if(curr_node.right):
                queue.append(curr_node.right)


        return result


'''
using DFS
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.res = 0

        def inorder(root):

            if root is None:
                return

            inorder(root.left)
            if(root.val>=low and root.val<=high ):

                self.res+=root.val

            inorder(root.right)

        inorder(root)

        return self.res


'''
Time complexity: O(n)
Space complexity : Recursion stack O(h) where h is the height of the tree in DFS approach
BFS uses O(n) space for the queue in the worst case.
'''
