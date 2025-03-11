# Problem 3
# Vertical Order Traversal of a Binary Tree (https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root: return result
        Map = {}
        q = deque()
        widthQ = deque()
        Min = float("inf")
        Max = float("-inf")
        q.append(root)
        widthQ.append(0)

        while q:
            curr = q.popleft()
            currWidth = widthQ.popleft()
            Min = min(Min,currWidth)
            Max = max(Max,currWidth)

            if curr.left:
                q.append(curr.left)
                widthQ.append(currWidth - 1)

            if curr.right:
                q.append(curr.right)
                widthQ.append(currWidth + 1)


            if currWidth not in Map:
                Map[currWidth] = []
            Map[currWidth].append(curr.val)

        print(Min,Max)
        for i in range(Min,Max+1):
            result.append(Map[i])

        return result

