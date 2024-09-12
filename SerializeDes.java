class SerializeDeserialize {
  /**
   * Time Complexity: O(n)
   *  n -> number of nodes in the tree
   * 
   * Space Complexity: O(n)
   * 
   * Were you able to solve this on leetcode? Yes
   */
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList();
    queue.add(root);
    while(!queue.isEmpty()){
        TreeNode curr = queue.poll();
        if(curr != null){
            queue.add(curr.left);
            queue.add(curr.right);
        }
        if(curr == null){
            sb.append("null");
        } else {
            sb.append(curr.val);
        }
        sb.append(',');
    }
    
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      if(data.equals("")) return null;
      int idx = 1;
      String[] values = data.split(",");
      TreeNode root = new TreeNode(Integer.parseInt(values[0]));
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty()){
          TreeNode curr = queue.poll();

          // process left child
          String left = values[idx];
          TreeNode leftNode = null;
          if(!left.equals("null")) {
              leftNode = new TreeNode(Integer.parseInt(left));
              queue.add(leftNode);
          }
          curr.left = leftNode;
          
          idx++;
          
          // process right child
          String right = values[idx];
          TreeNode rightNode = null;
          if(!right.equals("null")){
              rightNode = new TreeNode(Integer.parseInt(right));
              queue.add(rightNode);
          }
          curr.right = rightNode;
          
          idx++;
      }
      return root;
  }
}
