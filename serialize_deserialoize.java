//TC: O(n)
//SC: O(n)

public class serialize_deserialoize {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(root, sb);
            sb.deleteCharAt(sb.length() - 1); // delete the last redundant comma ","
            return sb.toString();
        }
    
        void preOrderTraverse(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null,");
                return;
            }
            sb.append(root.val);
            sb.append(",");
            preOrderTraverse(root.left, sb);
            preOrderTraverse(root.right, sb);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            nodes = data.split(",");
            return dfs();
        }
        
        int i = 0;
        String[] nodes;
        TreeNode dfs() {
            if (i == nodes.length) return null;
            String val = nodes[i];
            i += 1;
            if (val.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs();
            root.right = dfs();
            return root;
        }
    }
}
