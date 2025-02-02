import java.util.*;

public class problem1 {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int result;
    public int rangeSumBST(Node root, int low, int high) {

    result=0;
    helper(root, low, high);
    return result;
    }
    private void helper(Node root, int low, int high) {
        if(root==null) return;
        if (root.val<=low && root.val>=high)
        {
            result+=root.val;
        }
        helper(root.left, low, high);
        helper(root.right, low, high);
    }


    }
