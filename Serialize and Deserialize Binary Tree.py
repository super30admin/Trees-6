'''
Time Complexity: O(N) -> To seralize and deseralize
Space Complexity: O(N)
Did this code successfully run on Leetcode : Yes
Explanation:
Do Pre-order BFS and append the elements into a string. Make sure to include Null Nodes as well.
After creating the string have a cursor = 0, for every iteration, the queue will contain the node where the elements
need to be added to ie Parent and have the cursor to go through the string array.
For example we know for Pre order it is root left right so add root to queue, now set cursor to 1 as root is processed
if array[cursor]!=None append the element to the left subtree of root, increase the cursor by 1 and now check if the right
is None or not.

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return ''
        queue = [root]
        res = ''  # output

        while len(queue) != 0:
            cursor = queue[0]
            queue = queue[1:]

            if cursor == None:
                res += 'None,'
                continue

            res += str(cursor.val) + ','

            queue.append(cursor.left)
            queue.append(cursor.right)

        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == None or data == '':
            return None

        tokens = data.split(',')
        root = TreeNode(tokens[0])
        cursor = 1  # as root already visited
        queue = [root]
        while len(queue) != 0:
            current = queue[0]
            queue = queue[1:]

            if tokens[cursor] != 'None':
                current.left = TreeNode(int(tokens[cursor]))
                queue.append(current.left)

            cursor += 1

            if tokens[cursor] != 'None':
                current.right = TreeNode(int(tokens[cursor]))
                queue.append(current.right)

            cursor += 1
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))