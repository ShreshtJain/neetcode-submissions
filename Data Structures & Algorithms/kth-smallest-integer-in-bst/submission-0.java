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
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<TreeNode> stack = new Stack<TreeNode>();

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
            
            pq.offer(root.val);
            if(pq.size()>k)
                pq.poll();
            
            root=root.right;
        }
        return pq.poll();
    }
}
