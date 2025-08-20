"""
Serialize (BFS): write nodes level-by-level, using a null marker (e.g., #) so structure can be reconstructed
Deserialize (BFS): read tokens left->right; use a queue to attach children to parents in order
Null markers ensure we know where subtrees end, even with missing children
"""
"""
Serialize: O(n) time, O(n) space for the queue/output
Deserialize: O(n) time, O(n) space for the queue/tree
"""
from collections import deque
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class serializeDeserialize:
    SEP = ','
    NIL = '#'

    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ''
        out = []
        q = deque([root])
        while q:
            node = q.popleft()
            if node:
                out.append(str(node.val))
                q.append(node.left)
                q.append(node.right)
            else:
                out.append(self.NIL)

        while out and out[-1] == self.NIL:
            out.pop()
        return self.SEP.join(out)

    def deserialize(self, data: str) -> Optional[TreeNode]:

        if not data:
            return None
        vals = data.split(self.SEP)
        root = TreeNode(int(vals[0]))
        q = deque([root])
        i = 1
        while q and i < len(vals):
            node = q.popleft()

            # left child
            if i < len(vals):
                if vals[i] != self.NIL:
                    node.left = TreeNode(int(vals[i]))
                    q.append(node.left)
                i += 1

            # right child
            if i < len(vals):
                if vals[i] != self.NIL:
                    node.right = TreeNode(int(vals[i]))
                    q.append(node.right)
                i += 1
        return root

def level_order(root: Optional[TreeNode]) -> list:
    from collections import deque
    if not root:
        return []
    res, q = [], deque([root])
    while q:
        node = q.popleft()
        if node:
            res.append(node.val)
            q.append(node.left)
            q.append(node.right)
        else:
            res.append(None)

    while res and res[-1] is None:
        res.pop()
    return res

if __name__ == "__main__":
    root = TreeNode(1,
                    TreeNode(2),
                    TreeNode(3, TreeNode(4), TreeNode(5)))

    c = serializeDeserialize()
    s = c.serialize(root)
    print("Serialized (BFS):", s)
    r = c.deserialize(s)
    print("Level order after round-trip:", level_order(r))