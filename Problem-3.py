#314. Binary Tree Vertical Order Traversal
#https://leetcode.com/problems/binary-tree-vertical-order-traversal/
"""
TC: O(n+k) n = number of nodes, k = max width of tree
SC: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = deque()
        q.append((root,0))
        hash_map = defaultdict(list)
        max_, min_ = 0, 0
        while q:
            size = len(q)
            for _ in range(size):
                curr_node, idx = q.popleft()
                hash_map[idx].append(curr_node.val)
                if curr_node.left:
                    q.append((curr_node.left, idx - 1))
                    min_ = min(min_, idx-1)
                if curr_node.right:
                    q.append((curr_node.right, idx + 1))
                    max_ = max(max_, idx+1)
        result = []
        for i in range(min_, max_+1):
            result.append(hash_map[i])
        return result