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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode prev=null;
        
        if(root==null)
            return list;

        q.offer(root);
        q.offer(null);



        while(!q.isEmpty())
        {
            TreeNode node = q.poll();

            if(node==null)
            {
                list.add(prev.val);
                if(!q.isEmpty())
                {
                    q.offer(null);
                }
                continue;
            }

            if(node.left!=null)
                q.offer(node.left);
            
            if(node.right!=null)
                q.offer(node.right);
            prev=node;
        }

        return list;
    }
}
