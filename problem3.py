# https://leetcode.com/problems/binary-tree-vertical-order-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.hash_map = {}
        if not root:
            return []
        value_queue = deque([root])
        idx_queue = deque([0])
        while(value_queue):
            popped_val = value_queue.popleft()
            popper_idx = idx_queue.popleft()
            if popper_idx in self.hash_map:
                self.hash_map[popper_idx].append(popped_val.val)
            else:
                self.hash_map[popper_idx] = [popped_val.val]
            if popped_val.left:
                value_queue.append(popped_val.left)
                idx_queue.append(popper_idx-1)
            if popped_val.right:
                value_queue.append(popped_val.right)
                idx_queue.append(popper_idx+1)
        final_result = []
        for idx in sorted(list(self.hash_map.keys())):
            final_result.append(self.hash_map[idx])
        return final_result


    