/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
 * TC O(n)
 * SC O(n)
 * */
/*class Solution
{

    public int rangeSumBST(TreeNode root, int low, int high)
    {
        int sum = 0;

        if(root==null)
            return sum;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int n = queue.size();

            for(int i=0;i<n;i++)
            {
                TreeNode temp = queue.remove();

                if(temp.val>=low && temp.val<=high)
                {
                    //System.out.println("val:"+temp.val);
                    sum = sum + temp.val;
                }

                if(temp.left!=null)
                    queue.add(temp.left);

                if(temp.right!=null)
                    queue.add(temp.right);

            }

        }
        return sum;
    }

}*/

/*class Solution
{
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high)
    {

        if(root==null)
            return sum;

        dfs(root,low,high);

        return sum;

    }

    public void dfs(TreeNode root, int low, int high)
    {
        //base
        if(root==null)
            return;

        //logic
        if(root.val>=low && root.val<=high)
        {
            sum = sum + root.val;
        }

        if(root.val>low)
        {
            dfs(root.left,low,high);
        }

        if(root.val<high)
        {
            dfs(root.right,low,high);
        }

    }
}*/

/*class Solution
{
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high)
    {

        int sum = 0;

        if(root==null)
            return sum;

        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);

                root = root.left;

            }

            root = stack.pop();

            if(root.val>=low && root.val<=high)
            {
                sum = sum + root.val;
            }

            root = root.right;
        }

        return sum;
    }

}*/

class SolutionOne
{
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high)
    {

        int sum = 0;

        if(root==null)
            return sum;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty())
        {

            root = stack.pop();

            if(root==null)
                continue;

            if(root.val>=low && root.val<=high)
            {
                sum = sum + root.val;
            }

            if(root.val<high)
            {
                stack.push(root.right);
            }

            if(root.val>low)
            {
                stack.push(root.left);
            }

        }

        return sum;
    }

}