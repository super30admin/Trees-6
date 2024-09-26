# Problem 1 - Range Sum of BST
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: DFS
      class Solution:
          def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
              def dfs(root: TreeNode, L: int, R: int):
                  if not root:
                      return 0
                  #Case1
                  if root.val>=L and root.val<=R:
                      return dfs(root.left,L,R) + root.val + dfs(root.right,L,R)
                  #Case2
                  elif root.val<L:
                      return dfs(root.right,L,R)
                  #Case3
                  return dfs(root.left,L,R)

              return dfs(root, L, R)

# Problem 1 - Range Sum of BST
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
No - Time Limit Exceeded.

## Any problem you faced while coding this :
Yes. Cannot figure out why the code is not running.

## Your code here along with comments explaining your approach
### Solution 2: BFS
      class Solution:
          def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
              if not root:
                  return 0
              queue = []
              result = 0
              queue.append(root)
              while queue:
                  root=queue[0]

                  if root.val>=L and root.val<=R:
                      result+=root.val
                      if root.left:
                          queue.append(root.left)
                      if root.right:
                          queue.append(root.right)
                  elif root.val<L:
                      if root.right:
                          queue.append(root.right)
                  else:
                      if root.left:
                          queue.append(root.left)
              return result


# Problem 2 - Serialize and Deserialize Binary Tree
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution: 
      class Codec:
          def serialize(self, root):
              """Encodes a tree to a single string.
              :type root: TreeNode
              :rtype: str
              """
              retStr = ""

              # edge case
              if root == None:
                  return retStr

              queue = []
              queue.append(root)

              # BFS
              while queue:
                  front = queue.pop(0)

                  if front == None:
                      retStr += "NULL,"
                  else:
                      retStr += str(front.val) + ","
                      queue.append(front.left)
                      queue.append(front.right)

              # removing the nulls added at end of string to optimize the deserialize method.
              while not retStr[len(retStr) - 1].isnumeric():
                  retStr = retStr[0:len(retStr) - 1]

              return retStr

          def deserialize(self, data):
              """Decodes your encoded data to tree.
              :type data: str
              :rtype: TreeNode
              """
              # edge case
              if data == "":
                  return None

              # split data in a string into a list for further deserializing process.
              processed = data.split(',')
              index = 0  


              root = TreeNode(int(processed[index]))
              index += 1

              queue = []
              queue.append(root)

              # BFS for deserializing the string to Tree.
              while queue and index < len(processed):
                  front = queue.pop(0)


                  if index < len(processed) and processed[index] != "NULL":
                      front.left = TreeNode(int(processed[index]))
                      queue.append(front.left)
                  index += 1

                  if index < len(processed) and processed[index] != "NULL":
                      front.right = TreeNode(int(processed[index]))
                      queue.append(front.right)
                  index += 1

              return root


# Problem 3 - Invert Binary Tree
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution: 
      class Solution:
          def invertTree(self, root: TreeNode) -> TreeNode:
              if not root:
                  return
              root.left, root.right = root.right, root.left
              self.invertTree(root.left)
              self.invertTree(root.right)
              return root
