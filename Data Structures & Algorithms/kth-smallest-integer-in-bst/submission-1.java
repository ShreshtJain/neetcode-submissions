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

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int val=-1;

        while(k>0)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }

            if(stack.isEmpty())
            {
                break;
            }

            root=stack.pop();
            val=root.val;
            root=root.right;
            k--;
        }
        return val;
    }
}
