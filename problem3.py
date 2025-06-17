# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        map = {}
        res = []

        if not root:
            return res

        min_col = 0
        queue = collections.deque()

        queue.append((root,0))

        while queue:
            size = len(queue)
            for _ in range(size):
                cur, cur_col = queue.popleft()
                min_col = min(min_col, cur_col)
                if cur_col in map:
                    map[cur_col].append(cur.val)
                else:
                    map[cur_col] = [cur.val]
                if cur.left:
                    queue.append((cur.left, cur_col-1))
                if cur.right:
                    queue.append((cur.right, cur_col+1))

        for c in range(min_col, min_col + len(map)):
            res.append(map[c])

        return res