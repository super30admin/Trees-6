# Approach - Brute Force DFS
# Process all nodes and check if it falls within the range, if it does, add to result
# Time - O(N)
# Space - O(N)

class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        # DFS Brute Force process all nodes check if within range add to result
        
        if not root:
            return 0
        
        self.result = 0
        
        self.dfs(root, low, high)
        
        return self.result
    
    
    def dfs(self, root, low, high): # void function type
        
        # base 
        if root == None:
            return 
        
        # logic
        
        if root.val >= low and root.val <= high:
            self.result += root.val
            
        self.dfs(root.left, low, high)
        self.dfs(root.right, low, high)
        
        
## Optimised approach - Still O(N) Time and Space but in worst case, if not it is more optimised
# Before calling the dfs on left and right child check to see if the root node(current) node is within the range that is if root > low process left child ( if not there may be a right child which is in range, which we need to process)
# If root < high process right child - if not true there could be a left child in range

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        # DFS Brute Force process all nodes check if within range add to result
        
        if not root:
            return 0
        
        self.result = 0
        
        self.dfs(root, low, high)
        
        return self.result
    
    
    def dfs(self, root, low, high): # void function type
        
        # base 
        if root == None:
            return 
        
        # logic
        
        if root.val >= low and root.val <= high:
            self.result += root.val
           
        if root.val > low:
            self.dfs(root.left, low, high)
            
        if root.val < high:
            self.dfs(root.right, low, high)
        
        


## Brute Force - Iterative DFS (aux stack) - Uses inorder
# 
class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        
        st = []
        
        while st or root != None:
            
            while root != None:
                st.append(root)
                
                root = root.left
                
            # root hits null, pop and move to right
            root = st.pop()
            
            # now process the node for result
            
            if root.val >= low and root.val <= high:
                result += root.val
            
            root = root.right
                
                
        return result    


# Optimised Iterative solution - Inorder

class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        
        st = []
        
        while st or root != None:
            
            while root != None:
                st.append(root)
                
                if root.val < low:
                    # break out of the loop and process other nodes
                    break
                
                root = root.left
                
            # root hits null, pop and move to right
            root = st.pop()
            
            # now process the node for result
            
            if root.val >= low and root.val <= high:
                result += root.val
            
            if root.val < high:

                root = root.right
                
            else:
                # need to assign None node as it is not iterative here unlike processing left with a while loop
                root = None
                
        return result




# Optimised Solution - Pre order ( root, left, right)

class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        
        st = []
        st.append(root)
        
        while st:
            current = st.pop()
            
            if current:
            
                if current.val >= low and current.val <= high:
                    result += current.val


                if current.val > low:
                    st.append(current.left)

                if current.val < high:
                    st.append(current.right)

        return result
           
            

      

##### BFS ####

# Brute Force - BFS - Process all nodes and check for range
# Time - O(N)
# Space - O(N)

class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        
        queue = collections.deque()
        queue.append(root)
        
        while queue:
            
            current = queue.popleft()
            
            if current.val >= low and current.val <= high:
                result += current.val
                
            if current.left:
                queue.append(current.left)
                
            if current.right:
                queue.append(current.right)
                
        return result
                
        
## Optimized Brute Force
# Time - O(N)
# Space - O(N)

class Solution:
    
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root:
            return 0
        
        result = 0
        
        queue = collections.deque()
        queue.append(root)
        
        while queue:
            
            current = queue.popleft()
            
            if current:
                # here this null check is required as we are not going through all nodes, at times we skip left child and process right or vice versa
                
                if current.val >= low and current.val <= high:
                    result += current.val

                if current.val > low:
                    queue.append(current.left)

                if current.val < high:
                    queue.append(current.right)
                
        return result
                
        
        