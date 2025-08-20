"""
In a BST, left subtree < node < right subtree — so we can prune branches outside [low, high]
If node.val < low, skip the left; if node.val > high, skip the right; otherwise add node.val and explore both
This yields faster-than-full traversal on average
"""
"""
Time Complexity: O(k + h) average (visits nodes near the range; worst-case O(n))
Space Complexity: O(h) recursion stack (worst-case O(n) for skewed tree)
"""
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left:'Optional[TreeNode]'=None, right:'Optional[TreeNode]'=None):
        self.val = val
        self.left = left
        self.right = right

class rangeSumBST:
    def rangeSumBSTVal(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        if root.val < low:
            return self.rangeSumBSTVal(root.right, low, high)
        if root.val > high:
            return self.rangeSumBSTVal(root.left, low, high)
        # root.val within range
        return (root.val +
                self.rangeSumBSTVal(root.left, low, high) +
                self.rangeSumBSTVal(root.right, low, high))

def insert_bst(root: Optional[TreeNode], val: int) -> TreeNode:
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_bst(root.left, val)
    else:
        root.right = insert_bst(root.right, val)
    return root

if __name__ == "__main__":
    vals = [10,5,15,3,7,18]
    root = None
    for v in vals:
        root = insert_bst(root, v)

    obj = rangeSumBST()
    print(obj.rangeSumBSTVal(root, 7, 15))   # 32  (7 + 10 + 15)


