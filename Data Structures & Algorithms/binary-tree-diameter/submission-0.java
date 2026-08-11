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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinaryTree(root);

        return diameter;
    }

    int heightOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;

        
        int left=heightOfBinaryTree(root.left);
        int right=heightOfBinaryTree(root.right);

        if(diameter<left+right)
            diameter=left+right;
        
        return left>right?left+1:right+1;
    }

}
