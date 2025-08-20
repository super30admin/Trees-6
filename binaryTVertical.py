"""
Do a BFS keeping track of each node’s column index (col): root at 0, left col-1, right col+1
Append values into a hash map col -> list as we pop from the queue; BFS naturally preserves top-to-bottom, left-to-right order within each column
After traversal, output lists for columns from min_col to max_col
"""
"""
Time Complexity: O(n) — visit each node once
Space Complexity: O(n) — queue + column buckets
"""


from collections import defaultdict, deque
from typing import Optional, List

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class binaryTVertical:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        col_to_vals = defaultdict(list)
        q = deque([(root, 0)])  # (node, col)
        min_col = max_col = 0

        while q:
            node, col = q.popleft()
            col_to_vals[col].append(node.val)
            min_col = min(min_col, col)
            max_col = max(max_col, col)

            if node.left:
                q.append((node.left, col - 1))
            if node.right:
                q.append((node.right, col + 1))

        return [col_to_vals[c] for c in range(min_col, max_col + 1)]


def build_tree_level(vals: List[Optional[int]]) -> Optional[TreeNode]:
    if not vals:
        return None
    it = iter(vals)
    root_val = next(it)
    if root_val is None:
        return None
    root = TreeNode(root_val)
    q = deque([root])
    for v_left, v_right in zip(it, it):
        node = q.popleft()
        if v_left is not None:
            node.left = TreeNode(v_left)
            q.append(node.left)
        if v_right is not None:
            node.right = TreeNode(v_right)
            q.append(node.right)
    return root

if __name__ == "__main__":
    root1 = build_tree_level([3, 9, 20, None, None, 15, 7])
    print(binaryTVertical().verticalOrder(root1))  # [[9], [3, 15], [20], [7]]
