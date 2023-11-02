//Problem 1: Sum between two ranges
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Travel through the tree and check whether node value falls between the range.
class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        // return helper(root, low, high);
        // Stack<TreeNode> q= new Stack<>();
        // q.add(root);
        // int res=0;
        // while(!q.isEmpty()){
        //     TreeNode cur=q.pop();
        //     if(cur.val>=low && cur.val<=high){
        //         res+=cur.val;
        //     }

        //     if(cur.left!=null && cur.val>low){
        //         q.add(cur.left);
        //     }
        //     if(cur.right!=null && cur.val<high){
        //         q.add(cur.right);
        //     }
        // }
        // return res;

        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (current.val >= low && current.val <= high) {
                ans += current.val;
            }

            current = current.right;
        }

        return ans;
    }

    //base recursion O(n)
    // private int helper(TreeNode root, int low, int high){
    //     //base
    //     if(root==null) return 0 ;
    //     //logic
    //     int res=0, left=0, right=0;
    //     if(root.val>low)
    //        left= helper(root.left, low, high);
    //     if(root.val>=low && root.val<=high){
    //         res+=root.val;
    //     }
    //     if(root.val<high)
    //         right = helper(root.right, low, high);

    //     return res+left+right;
        
    // }
}

//Problem 2: Serialize and Deserialize BT
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Traverse through the tree to store it the value in a String builder, put # for null and keep , seperated values for spliiting at the time of deserializing
public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb= new StringBuilder();
    public String serialize(TreeNode root) {
        if(root==null) return "";
        sb=new StringBuilder();
        // Queue<TreeNode> q= new LinkedList<>();
        // StringBuilder sb= new StringBuilder();

        // q.add(root);
        // while(!q.isEmpty()){
        //     TreeNode cur=q.poll();
        //     if(cur==null){
        //         sb.append("#");
        //     }else{
        //         sb.append(cur.val);
        //         q.add(cur.left);
        //         q.add(cur.right);
        //     }
        //     sb.append(',');
        // }
        serializehelper(root);
        return sb.toString();
    }
    private void serializehelper(TreeNode root){
        //base
        if(root==null){
            sb.append("#");
            sb.append(",");
            return;
        }

        //logic
        sb.append(root.val);
        sb.append(",");
        serializehelper(root.left);
        serializehelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] split=data.split(",");
        // TreeNode root= new TreeNode(Integer.parseInt(split[0]));
        // int idx=1;
        // Queue<TreeNode> q= new LinkedList<>();
        // q.add(root);
        // while(idx<split.length && !q.isEmpty()){
        //     TreeNode cur=q.poll();
        //     if(!split[idx].equals("#")){
        //         cur.left= new TreeNode(Integer.parseInt(split[idx]));
        //         q.add(cur.left);
        //     }
        //     idx++;

        //     if(!split[idx].equals("#")){
        //         cur.right= new TreeNode(Integer.parseInt(split[idx]));
        //         q.add(cur.right);
        //     }
        //     idx++;
        // }
        // return root;
        
        return deserializehelper(split);
    }
    int idx;
    private TreeNode deserializehelper(String[] split){
        if(idx==split.length) return null;

       if(split[idx].equals("#")){
           idx++;
           return null;
       }
       TreeNode root= new TreeNode(Integer.parseInt(split[idx]));
       idx++;
       root.left=deserializehelper(split);
       root.right=deserializehelper(split);
       return root;
    }
}

//Problem 3: Vertical Order traversal
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Traverse through the tree keeping root depth as 0 and reduce 1 for left subtree and increase 1 for right subtree.
// recursively store the values in a hashmap with depth as key.
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        int min=0, max=0;
        if(root==null) return res;
        Queue<TreeNode> q= new LinkedList<>();
        Queue<Integer> depthq= new LinkedList<>();
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        q.add(root);
        depthq.add(0);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            int curCol=depthq.poll();
            
            if(!map.containsKey(curCol)){
                map.put(curCol, new ArrayList<>());
            }
            map.get(curCol).add(cur.val);
            
            if(cur.left!=null){
                q.add(cur.left);
                depthq.add(curCol-1);
                min=Math.min(min, curCol-1);
            }
            if(cur.right!=null){
                q.add(cur.right);
                depthq.add(curCol + 1);
                max=Math.max(max, curCol+1);
            }
        }

        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }

        return res;
    }
}
