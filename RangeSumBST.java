/*
Time Complexity: O(N), N is the number of nodes in the given tree
Space Complexity: O(N), N is the number of nodes
Any difficulties: no
Run on leetcode: Yes

Approach:
1. Range Sum is calculated recursively, if the given low and high are less than and greater than the root node respectively,
one can directly add that to the result
2. If the low is less than the root.val then recursively traverse the left side of the tree
3. If the high is greater than the root.val then recursively traverse the right side of the tree
 */
public class RangeSumBST {
    public static int result;
    public static int rangeSumBST(TreeNode root, int low, int high){
        result = 0;
        sumBST(root, low, high);
        return result;
    }
    public static void sumBST(TreeNode root, int low, int high){
        if(root!= null){
            if(low<=root.val && root.val<=high){
                result+= root.val;
            }if(low<root.val){
                sumBST(root.left, low, high);
            }if(high>root.val){
                sumBST(root.right, low, high);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        System.out.println("Range Sum BST: "+ rangeSumBST(root, 7, 15));
    }
}
