'''
314 Binary Tree Vertical Order Traversal
https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Example 2:
Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]

Example 3:
Input: root = [1,2,3,4,10,9,11,null,5,null,null,null,null,null,null,null,6]
Output: [[4],[2,5],[1,10,9,6],[3],[11]]


Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Solution:
1. BFS
We perform level order traversal while tracking each node's width.
We enque the root and it's width = 0.
Step 1: Pop the element in q. Get its width (w).
Step 2: Add the element to a hash map with the key as width.
Step 3: Compute min_width and max_width.
Step 4: Enque the left child along with its width w - 1
        Enque the right child along with its width w + 1
Step 5: If queue is not empty, Go to Step 1. If mepty, exit
Step 6: Iterate over the keys of the hash map from min_width to max_width and store the values in a list. Output the list.
https://youtu.be/IaeuIpNbN50?t=575
Time: O(N), Space: O(N)


2. DFS
We could do DFS while tracking the width (like in BFS). But this might fail in certain cases. Consider the example below (also given as a test case)
  ___3_
 /     \
 9    10_
/ \      \
8 7     12
   \
   6
    \
    5

Running DFS (inorder traversal) on this generates the following hash map <width, element>
-2: [8]
-1: [9]
0:  [3, 7]
1:  [6, 10]
2:  [5, 12]

At width 0 and 1, the element orderings are incorrect. They should be
1: [10, 6]
2: [12, 5]
Note that in the correct order, elements grouped under the same width could have different depths. Eg. Element 6 is at width 1, depth 3. Element 10 is at width 1, depth 1. Since 10 is at a lower depth, it should be appearing before 6.

Hence, in addition to the width, we need to consider the depth information of each node. The width decides the key in the hash map, the depth decides the ordering of the list.

Note that had we done a DFS a post order traversal (right, root, left) tracking only width, then this example wouldn't be a problem since the DFS would have added 10 and 12 at the beginning of the lists. However, it would fail on other examples. For eg, a long left skewed tail on the right subtree.
  ___3_
 /     \
 9    10_
/ \      \
8 7     12
  \     /
   4   6
      /
     5
DFS using width but no depth: width 1: [10, 6, 4]
DFS using width and depth:    width 1: [10, 4, 6]

Thus, the steps in DFS are:
Step 1: We use DFS to go through every node while tracking both width and depth.
Step 2: We store each node in a hashmap using its width and depth.
hashmap<key, list> where each element of a list is a tuple(node value, depth)
Step 3: Finally, we get the list for each width in the hashma pand sort the list by depth to maintain the top-down order.
https://youtu.be/IaeuIpNbN50?t=1505 (dry run 1 of an eg where DFS works)
https://youtu.be/IaeuIpNbN50?t=1832 (dry run 2 of an eg where DFS fails)

Time: O(N + WKlog K), Space: O(H), H = log N (non-skewed tree), N (skewed tree), W = no. of widths, K = avg no. of nodes per width

'''
from typing import Optional, List
from binary_tree import *
from collections import defaultdict, deque

def verticalOrder_bfs(root: Optional[TreeNode]) -> List[List[int]]:
    '''
    BFS using width
    Time: O(N), Space: O(N)
    '''
    q = deque()
    result = []
    h = defaultdict(list)
    width_min, width_max = float('inf'), float('-inf')
    q.append((root, 0))
    while q:
        x = q.popleft()
        curr, width = x[0], x[1]
        width_min = min(width, width_min)
        width_max = max(width, width_max)
        h[width].append(curr.val)
        if curr.left:
            q.append((curr.left, width-1))
        if curr.right:
            q.append((curr.right, width+1))
    for w in range(width_min, width_max+1):
        result.append(h[w])
    return result

def verticalOrder_dfs(root: Optional[TreeNode]) -> List[List[int]]:
    '''
    DFS using both width and depth
    Time: O(N + WKlog K), Space: O(H), H = log N (non-skewed tree), N (skewed tree), W = no. of widths, K = avg no. of nodes per width
    '''
    def dfs(curr, width, depth):
        nonlocal width_min, width_max
        if not curr:
            return None

        width_min = min(width, width_min)
        width_max = max(width, width_max)

        if not curr.left and not curr.right:
            h[width].append((curr.val, depth))
            return

        h[width].append((curr.val, depth))
        dfs(curr.left, width-1, depth+1)
        dfs(curr.right, width+1, depth+1)

    if not root:
        return [[]]

    h = defaultdict(list)
    width_min = float('inf')
    width_max = float('-inf')
    dfs(root, 0, 0)
    result = []

    for w in range(width_min, width_max+1): # O(W)
        # for width w, sort the list ordering by depth of elements
        h[w].sort(key = lambda x: x[1]) # O(K log K)
        result.append([item[0] for item in h[w]])
    return result

def run_verticalOrder():
    tests = [([3,9,20,None,None,15,7], [[9],[3,15],[20],[7]]),
             ([3,9,8,4,0,1,7], [[4],[9],[3,0,1],[8],[7]]),
             ([1,2,3,4,10,9,11,None,5,None,None,None,None,None,None,None,6], [[4],[2,5],[1,10,9,6],[3],[11]]),
             ([3,9,10,8,7,None,12,None,None,None,6,None,None,None,5],[[8], [9],[3,7],[10,6],[12,5]]), # dfs fails w/o depth information
    ]
    for test in tests:
        root, ans = test[0], test[1]
        print(f"\nroot = {root}")
        tree=build_tree_level_order(root)
        tree.display()
        for method in ['bfs', 'dfs']:
            if method == 'dfs':
                result = verticalOrder_dfs(tree)
            elif method == 'bfs':
                result = verticalOrder_bfs(tree)
            print(f"Method {method}: result = {result}")
            success = (ans == result)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_verticalOrder()
