#Time Complexity:O(n)
#Space Complexity:O(n)
#Approach: Starting from root, node value at each level is parsed and those whse value is between the range is added to the queue and then
#into the rangeSum before parsing the child level.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0
        q=deque()
        q.append(root)
        rangeSum=0
        while q:
            curr=q.popleft()
            if low<=curr.val<=high:
                rangeSum+=curr.val
            if curr.left and curr.val>low:
                q.append(curr.left)
            if curr.right and curr.val<high:
                q.append(curr.right)
        return rangeSum
            