'''
297 Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format (https://support.leetcode.com/hc/en-us/articles/32442719377939-How-to-create-test-cases-on-LeetCode#h_01J5EGREAW3NAEJ14XC07GRW1A), so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []


Constraints:
The number of nodes in the tree is in the range [0, 10^4].
-1000 <= Node.val <= 1000

Solution:
1. BFS (easier to follow, follow this approach)
Serialize (tree to list)
We use level-order (BFS) to serialize the tree by visiting nodes level by level and marking nulls with 'None'. For each node dequed, we record the node's value in a string and add a ','. If the node is a None, we record the node's value as 'None'.
https://youtu.be/IaeuIpNbN50?t=3165 (ambiguity problem)
Time: O(N), Space: O(N)

Deserialize (list to tree)
During deserialization, we use a queue to build the tree level-wise from the serialized string. We attach left and right children in order while reading each node from the string.
https://youtu.be/IaeuIpNbN50?t=3815
Time: O(N), Space: O(N)

2. DFS
We serialize the tree using preorder DFS and add "None" for nulls. During deserialization, we read the string from start and build the tree in the same preorder pattern. We reconstruct the tree by assigning left first, then right, because of the preorder traversal.
Serialize:   Time: O(N), Space: O(H)
Deserialize: Time: O(N), Space: O(H)
'''
from binary_tree import *

class Codec_BFS:
    ''' BFS approach'''
    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        Time: O(N), Space: O(N)
        """
        if not root:
            return [None]
        q = deque()
        result = ""
        q.append(root)
        while q:
            curr = q.popleft()
            if curr is None:
                result += str('None')
            else:
                result += str(curr.val)
                q.append(curr.left)
                q.append(curr.right)
            result += ","
        return result[:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        Time: O(N), Space: O(N)
        """
        if not data:
            return TreeNode(None)
        data = data.split(',')
        # N = len(data)
        node_val = None if data[0] == 'None' else int(data[0])
        root = TreeNode(node_val)
        q = deque()
        q.append(root)
        i = 1
        while q:
            curr = q.popleft()
            node_val = None if data[i] == 'None' else int(data[i])
            if node_val:
                lchild = TreeNode(node_val)
                curr.left = lchild
                q.append(lchild)
            i += 1
            node_val = None if data[i] == 'None' else int(data[i])
            if node_val:
                rchild = TreeNode(node_val)
                curr.right = rchild
                q.append(rchild)
            i += 1
            # if i == N:
            #     break
        return root

class Codec_DFS:
    ''' DFS approach '''
    def serialize(self, root):
        if root is None:
            return None
        sb = []
        self.dfsSerialize(root, sb)
        return ','.join(sb)

    def dfsSerialize(self, root, sb):
        if root is None:
            sb.append('None')
            return
        sb.append(str(root.val))
        self.dfsSerialize(root.left, sb)
        self.dfsSerialize(root.right, sb)

    def deserialize(self, data):
        if data is None:
            return None
        splitArr = data.split(',')
        self.idx = 0
        return self.dfsDeserialize(splitArr)

    def dfsDeserialize(self, splitArr):
        if splitArr[self.idx] == 'None':
            self.idx += 1
            return None
        root = TreeNode(int(splitArr[self.idx]))
        self.idx += 1
        root.left = self.dfsDeserialize(splitArr)
        root.right = self.dfsDeserialize(splitArr)
        return root

def run_SerializeDeserialize():
    tests = [([1,2,3,None,None,4,5]),
             ([3,9,20,None,None,15,7]),
             ([]),
    ]
    for test in tests:
        root = ans = test
        tree=build_tree_level_order(root)
        print("\n\nOriginal Tree:")
        tree.display()

        # --- BFS ---
        # Your Codec object will be instantiated and called as such:
        print(f"\nroot={root}")
        ser = Codec_BFS()
        serial_list = ser.serialize(tree)
        print(f"List after BFS serialization = {serial_list}")
        deser = Codec_BFS()
        deserial_tree = deser.deserialize(serial_list)
        print(f"Tree after BFS deserialization:")
        deserial_tree.display()

        # --- DFS ---
        # Your Codec object will be instantiated and called as such:
        print(f"\nroot={root}")
        ser = Codec_DFS()
        serial_list = ser.serialize(tree)
        print(f"List after DFS serialization = {serial_list}")
        deser = Codec_DFS()
        deserial_tree = deser.deserialize(serial_list)
        print(f"Tree after DFS deserialization:")
        if deserial_tree:
            deserial_tree.display()


run_SerializeDeserialize()