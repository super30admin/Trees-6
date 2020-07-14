// /*
// // Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };
// */

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Depth First Traversal
// Serializing the nodes with its respective no of children. This information will help during deserialization.

class Codec {
    // Encodes a tree to a single string.
    
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        // System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void serializeHelper(Node root, StringBuilder sb) {
        // edge case
        if(root == null) {
            return;
        }
        else {
        
            // preorder traversal
            sb.append(root.val);
            sb.append(","); // delimiter
            List<Node> children = root.children;
            sb.append(children.size()+","); // adding children size for current parent
            for(int i = 0; i < children.size(); i++) {
                serializeHelper(children.get(i), sb);
            }
        }
    }
	
    int index = 0;
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] nums = data.split(",");
        return deserializaHelper(nums);
    }
    
    private Node deserializaHelper(String[] nums) {
        if(index == nums.length)
            return null;
        
        Node node = new Node(Integer.parseInt(nums[index]));
        index++;
        if(index < nums.length) {
            int childrenSize = Integer.parseInt(nums[index]);
            index++;
            node.children = new ArrayList<>();
            for(int i = 0; index < nums.length && i < childrenSize; i++) {
                node.children.add(deserializaHelper(nums));
            }
        }
        return node;
    }
}
    
