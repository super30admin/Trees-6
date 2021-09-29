# Trees-6

## Problem1: Sum between two ranges of BST(https://leetcode.com/problems/range-sum-of-bst)

// Time Complexity = O(N)
//Space Complexity = O(h)

/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  class Solution {
  int sum;
  public int rangeSumBST(TreeNode root, int low, int high) {
  // int sum=0;
  // if(root == null){
  // return sum;
  // }
  // Queue<TreeNode> queue = new LinkedList<>();
  // queue.add(root);
  // while(!queue.isEmpty()){
  // TreeNode current=queue.remove();
  // if( current.val >= low && current.val <= high ){
  // sum=sum+current.val;
  // }
  // if( current.left != null && current.val>low ){
  // queue.add(current.left);
  // }
  // if( current.right != null && current.val < high ){
  // queue.add(current.right);
  // }
  // }
  // return sum;
  if(root == null) {
  return 0;
  }

          helper(root,low,high);
          return sum;
      }

      private void helper(TreeNode root, int low, int high) {
          if(root == null) {
              return;
          }
          if(root.val >= low) {
              helper(root.left,low,high);
          }
          if(root.val >= low && root.val <= high) {
              sum+=root.val;
          }
          if(root.val <= high) {
              helper(root.right,low,high);
          }
      }

  }

## Problem2: Serialize and Deserialize Binary Tree (https://leetcode.com/problems/serialize-and-deserialize-binary-tree)

// Time Complexity = O(N)
//Space Complexity = O(N)

/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode(int x) { val = x; }
- }
  \*/
  public class Codec {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
          if(root == null) {
              return "";
          }
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);
          StringBuilder sb = new StringBuilder();
          sb.append(root.val);
          sb.append(",");

          while(!queue.isEmpty()) {
              TreeNode current = queue.poll();

              if(current.left != null) {
                  queue.add(current.left);
                  sb.append(current.left.val);
                  sb.append(",");
              } else {
                  sb.append("null,");
              }

              if(current.right != null) {
                  queue.add(current.right);
                  sb.append(current.right.val);
                  sb.append(",");
              } else {
                  sb.append("null,");
              }
          }
          //System.out.println(sb.toString());
          return sb.toString();
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
          if(data.equals("")) {
              return null;
          }
          String[] parts = data.split(",");
          Queue<TreeNode> queue = new LinkedList<>();
          TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
          queue.add(root);
          int idx = 1;
          while(!queue.isEmpty() && idx < parts.length) {
              TreeNode current = queue.poll();
              if(!parts[idx].equals("null")) {
                  current.left = new TreeNode(Integer.parseInt(parts[idx]));
                  queue.add(current.left);

              }
              idx++;
              if(!parts[idx].equals("null")) {
                  current.right = new TreeNode(Integer.parseInt(parts[idx]));
                  queue.add(current.right);
              }
              idx++;
          }

          return root;
      }

  }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// Problem : 3 Vertical order traversal of Binary Tree

// Time Complexity = O(N)
//Space Complexity = O(N)
/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  class Solution {
  public List<List<Integer>> verticalOrder(TreeNode root) {
  if(root == null) {
  return new ArrayList<>();
  }
  List<List<Integer>> result = new ArrayList<>();
  Queue<TreeNode> queue = new LinkedList<>();
  Queue<Integer> columns = new LinkedList<>();
  HashMap<Integer, List<Integer>> map = new HashMap<>();
  int min = 0;
  int max = 0;
  queue.add(root);
  columns.add(0);
  map.put(0, new ArrayList<>());
          while(!queue.isEmpty()) {
              TreeNode current = queue.poll();
              int column = columns.poll();
              // System.out.print(current.val);
              // System.out.println(column);
              min = Math.min(min, column);
              max = Math.max(max, column);

              if(!map.containsKey(column)) {
                  map.put(column, new ArrayList<>());
              }

              map.get(column).add(current.val);

              if(current.left != null) {
                  queue.add(current.left);
                  columns.add(column - 1);
              }
              if(current.right != null) {
                  queue.add(current.right);
                  columns.add(column + 1);
              }
          }
          //System.out.println(min +"," + max);
          for(int i = min; i <= max; i++) {
              result.add(map.get(i));
          }
          return result;

      }
  }
