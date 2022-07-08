using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
   public  class SerializeDeSerializeBinaryTree
    {/*
      * T.C: O(N) where n is no of nodes in tree
      * S.C: O(N)
      */
        public string serialize(TreeNode root)
        {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new Queue<TreeNode>();
            queue.Enqueue(root);

            while (queue.Count != 0)
            {
                TreeNode curr = queue.Dequeue();

                if (curr == null)
                {
                    sb.Append("null");
                    sb.Append(",");
                    continue;
                }
                sb.Append(curr.val);
                sb.Append(",");

                queue.Enqueue(curr.left);
                queue.Enqueue(curr.right);
            }

            return sb.ToString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(string data)
        {
            if (data == null) return null;

            string[] strArr = data.Split(',');
            Queue<TreeNode> queue = new Queue<TreeNode>();
            int i = 1;
            TreeNode root = new TreeNode(int.Parse(strArr[0]));
            queue.Enqueue(root);

            while (i < strArr.Length)
            {
                TreeNode curr = queue.Dequeue();
                if (strArr[i] != "null")
                {
                    curr.left = new TreeNode(int.Parse(strArr[i]));
                    queue.Enqueue(curr.left);
                }

                i++;

                if (strArr[i] != "null")
                {
                    curr.right = new TreeNode(int.Parse(strArr[i]));
                    queue.Enqueue(curr.right);

                }
                i++;
            }

            return root;
        }
    }
}
