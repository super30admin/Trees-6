# Approach - BFS is more optimal as we want to display top to bottom left to right values in tree
# Maintain in queue node with its level. For left child we pass level - 1
# For right child we pass level + 1
# We group these levels and their nodes repsectively in {} and return sorted order


# Time - O(N log N)
# Space - O(N)


class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        
        queue = collections.deque()
        # store node and level
        
        hashmap = dict()
        
        queue.append((root, 0))
        
        while queue:
            
            current, level = queue.popleft()
            
            if level not in hashmap:
                hashmap[level] = []
            
            hashmap[level].append(current.val)
            
            if current.left:
                queue.append((current.left, level -1))
                
                
            if current.right:
                queue.append((current.right, level + 1))
                
        return [hashmap[val] for val in sorted(hashmap)]
                

# Optimised approach - Instead of sorting the hashmap, we can maintain and update min and max levels and iterate the hashmap with these
# Time - O(N)
# Space - O(N)

class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        
        queue = collections.deque()
        # store node and level
        
        hashmap = dict()
        
        queue.append((root, 0))
        minCol = 0
        maxCol = 0
        
        while queue:
            
            current, level = queue.popleft()
            
            minCol = min(minCol, level)
            maxCol = max(maxCol, level)
            
            if level not in hashmap:
                hashmap[level] = []
            
            hashmap[level].append(current.val)
            
            if current.left:
                queue.append((current.left, level -1))
                
                
            if current.right:
                queue.append((current.right, level + 1))
                
        return [hashmap[val] for val in range(minCol, maxCol + 1)]
                

