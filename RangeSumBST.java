/**
 * Performs a depth-first traversal of the BST to sum all node values within the given range.
 * Uses pruning by skipping branches outside the range for efficiency.
 * Returns the cumulative sum of values between low and high inclusive.
 */
//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(H) where H is the height of the tree


public class RangeSumBST {
        public int ans = 0;
        public int rangeSumBST(TreeNode root, int low, int high) {
            sumInRange(root, low, high);
            return ans;
        }
    
        private void sumInRange(TreeNode root, int low, int high) {
            if (root == null) {
                return;
            } else {
                if (root.val >=low && root.val<=high) {
                    ans += root.val;
                }
                if (root.val > low) {
                    sumInRange(root.left, low, high);
                }
                if (root.val < high) {
                    sumInRange(root.right, low, high);
                }
            }  
        }
    }
