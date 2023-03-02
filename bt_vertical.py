# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = deque()
        q.append((root, 0))
        out = []
        hashmap = defaultdict(list)
        min_val = 0
        max_val = 0
        if not root:
            return out
        while q:
            par, idx = q.popleft()
            hashmap[idx].append(par.val)
            if par.left:
                min_val = min(min_val, idx-1)
                q.append((par.left, idx-1))
            if par.right:
                max_val = max(max_val, idx+1)
                q.append((par.right, idx+1))

        # for i in sorted(hashmap.keys()):
        #     out.append(hashmap[i])
        for i in range(min_val, max_val+1):
            out.append(hashmap[i])
        return out
