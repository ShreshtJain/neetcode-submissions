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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
    
        int prev = Integer.MIN_VALUE;

    while(true)
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
        
        if(prev>=root.val)
            return false;
        
        prev=root.val;
        inorder.add(root.val);
        root=root.right;
    }
    
    // for(int i=0;i<inorder.size()-1;i++)
    // {
    //     if(!(inorder.get(i)<inorder.get(i+1)))
    //         return false;
    // }

    return true;
    
    }
}
