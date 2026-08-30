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
    int[] preorder;
    int[] inorder;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        this.preorderIndex=0;

        return buildTree(0,inorder.length-1);
    }

    TreeNode buildTree(int inorderStart, int inorderEnd)
    {
        if(inorderStart>inorderEnd)
            return null;
        
        int data = preorder[preorderIndex++];
        TreeNode node = new TreeNode(data);
        int inorderIndex=-1;

        for(int i=inorderStart;i<=inorderEnd;i++)
        {
            if(inorder[i]==data)
                inorderIndex=i;
        }
        if(inorderStart==inorderEnd)
            return node;

        node.left=buildTree(inorderStart,inorderIndex-1);
        node.right=buildTree(inorderIndex+1,inorderEnd);
        
        return node;
    }

}
