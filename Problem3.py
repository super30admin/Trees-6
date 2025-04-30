class Solution:
    def verticalOrder(self, root):
        if not root:
            return []

        result = []
        q = deque()
        cols = deque()
        col_map = defaultdict(list)

        q.append(root)
        cols.append(0)

        min_col = 0
        max_col = 0

        while q:
            curr = q.popleft()
            col = cols.popleft()

            col_map[col].append(curr.val)

            if curr.left:
                q.append(curr.left)
                cols.append(col - 1)
                min_col = min(min_col, col - 1)

            if curr.right:
                q.append(curr.right)
                cols.append(col + 1)
                max_col = max(max_col, col + 1)

        for i in range(min_col, max_col + 1):
            result.append(col_map[i])

        return result