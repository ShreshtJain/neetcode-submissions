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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<>();

        if(root==null)
            return list;

        q.offer(root);
        q.offer(null);
        
        ArrayList<Integer> temp = new ArrayList<>();
        

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();

            if(node ==null)
            {
                list.add(temp);
                temp= new ArrayList<Integer>();
                if(!q.isEmpty())
                    q.offer(null);
                continue;
            }
            temp.add(node.val);
            
            if(node.left!=null)
            {
                q.offer(node.left);
            }
                
            if(node.right!=null)
            {
                q.offer(node.right);
            }
        }
    return list;
    }
}
