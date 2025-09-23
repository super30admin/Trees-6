'''
938 Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst/description/

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

Constraints:
The number of nodes in the tree is in the range [1, 2 * 10^4].
1 <= Node.val <= 10^5
1 <= low <= high <= 10^5
All Node.val are unique.

Solution:
1. DFS
Initialize sum = 0. Traverse tree using DFS. At each node, if node.val is within [low, high] range, add it to the sum.
Time: O(N), Space: O(H)
'''
from binary_tree import *
from typing import Optional
def rangeSumBST(root: Optional[TreeNode], low: int, high: int) -> int:
    def dfs(curr, low, high):
        nonlocal sum

        if not curr:
            return None

        if not curr.left and not curr.right:
            if low <= curr.val <= high:
                sum += curr.val
            return None

        if low <= curr.val <= high:
            sum += curr.val
        dfs(curr.left, low, high)
        dfs(curr.right, low, high)

    if not root:
        return 0
    sum = 0
    dfs(root, low, high)
    return sum

def run_rangeSumBST():
    tests = [([10,5,15,3,7,None,18], 7, 15, 32),
             ([10,5,15,3,7,13,18,1,None,6], 6, 10, 23),
    ]
    for test in tests:
        root, low, high, ans = test[0], test[1], test[2], test[3]
        print(f"\nroot = {root}")
        print(f"range = [{low}, {high}]")
        tree=build_tree_level_order(root)
        tree.display()
        sum = rangeSumBST(tree, low, high)
        print(f"Range Sum = {sum}")
        success = (ans == sum)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_rangeSumBST()
