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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        int left = height(root.left);
        int right = height(root.right);

        boolean leftB = isBalanced(root.left);
        boolean rightB = isBalanced(root.right);

        if(!(leftB&&rightB))
            return false;
            
        if(left==right||left==right+1||left==right-1)
            return true;
        
        return false;
    }
    int height(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int left=height(root.left);
        int right=height(root.right);

        return left>right?left+1:right+1;
    }
}
