# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # I am gonna solve it using two queues
        # one queue for using the nodes
        # One queue for storing their column value.

        if not root:
            return []

        node_queue = deque()
        column_queue = deque()

        node_queue.append(root)
        column_queue.append(0)

        hash_map={}

        left_max = float('inf')
        right_max = float('-inf')

        while(node_queue and column_queue):

            curr_root = node_queue.popleft()
            curr_index = column_queue.popleft()

            if curr_index<left_max:
                left_max = curr_index
            if curr_index > right_max:
                right_max = curr_index

            if curr_index in hash_map:
                hash_map[curr_index].append(curr_root.val)
            else:
                hash_map[curr_index] = []
                hash_map[curr_index].append(curr_root.val)


            if(curr_root.left):
                node_queue.append(curr_root.left)
                column_queue.append(curr_index-1)

            if(curr_root.right):
                node_queue.append(curr_root.right)
                column_queue.append(curr_index+1)

        result_arr =[]
        for i in range(left_max, right_max+1):
            result_arr.append(hash_map[i])

        return result_arr

'''
Time Complexity: O(n) : Because we are visiting each node once.
Space Complexity: O(n) : Because we are using a hash map to store the nodes in each column, and also using two queues to store the nodes and their column indices.
'''
