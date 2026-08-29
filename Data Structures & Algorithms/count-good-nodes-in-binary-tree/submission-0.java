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
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        return preorder(root,root.val);
    }

    int preorder(TreeNode root, int max)
    {
        if(root==null)
            return 0;

        if(root.val>=max)
        {
            return 1+preorder(root.left,root.val)+preorder(root.right,root.val);
        }

        return preorder(root.left,max)+preorder(root.right,max);
    }
}
