# Approach:
# We use a Breadth-First Search (BFS) approach to traverse the tree level by level.
# We maintain a queue that stores (node, column_index) pairs.
# We use a dictionary to map column indices to lists of node values.
# The left child is assigned column - 1, and the right child is assigned column + 1.
# Finally, we sort the dictionary keys (columns) and return the node values in sorted column order.

# Time Complexity: O(n), where n is the number of nodes in the tree, since each node is visited once.
# Space Complexity: O(n), for storing nodes in the queue and dictionary.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        # Dictionary to store nodes grouped by their column index
        column_table = defaultdict(list)
        
        # Queue for BFS traversal (stores (node, column index))
        queue = deque([(root, 0)])
        
        while queue:
            node, col = queue.popleft()  # Process the node
            
            if node:
                column_table[col].append(node.val)  # Add node value to its column list
                
                # Add left child to queue with column index -1
                queue.append((node.left, col - 1))
                
                # Add right child to queue with column index +1
                queue.append((node.right, col + 1))
        
        # Sort columns and return values in order
        return [column_table[col] for col in sorted(column_table.keys())]

# Test cases
root1 = TreeNode(3, 
                 TreeNode(9), 
                 TreeNode(20, TreeNode(15), TreeNode(7)))
solution = Solution()
print(solution.verticalOrder(root1))  # Output: [[9],[3,15],[20],[7]]

root2 = TreeNode(3, 
                 TreeNode(9, TreeNode(4), TreeNode(0)), 
                 TreeNode(8, TreeNode(1), TreeNode(7)))
print(solution.verticalOrder(root2))  # Output: [[4],[9],[3,0,1],[8],[7]]

root3 = TreeNode(1, 
                 TreeNode(2, TreeNode(4, None, TreeNode(5))), 
                 TreeNode(3, TreeNode(10), TreeNode(9, None, TreeNode(6))))
print(solution.verticalOrder(root3))  # Output: [[4],[2,5],[1,10,9,6],[3],[11]]
