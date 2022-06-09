import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(n); where n is total number of nodes in the tree.
//Space Complexity : O(n)
public class SerializeDeserializeBT {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**Approach: BFS**/
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            } else{
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] strArr = data.split(",");
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode root= new TreeNode(Integer.parseInt(strArr[0]));        
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<strArr.length){  
            TreeNode curr = q.poll();
            System.out.print(curr.val+" ");
            if(!strArr[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);                                
            }
            i++;
            if(!strArr[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);                
            }
            i++;            
        }
        return root;
    }	

	/** Driver code to test above **/
    public static void main(String args[]) {
    	SerializeDeserializeBT ob = new SerializeDeserializeBT();
    	TreeNode t= new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));	    	
    	
		String str= ob.serialize(t);		
		System.out.println("Serialized Tree is: "+str);	
		
		System.out.print("Deserialized Tree is: ");
		TreeNode t2= ob.deserialize(str);				
	}	
}
