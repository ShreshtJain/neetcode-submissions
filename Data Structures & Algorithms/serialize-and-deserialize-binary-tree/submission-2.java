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

public class Codec {
    StringBuilder preorder = new StringBuilder();
    int preorderIndex=0;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder(root);
        return preorder.toString();
    }

    void preorder(TreeNode root)
    {
        if(root!=null)
        {
            preorder.append(root.val).append(",");
            preorder(root.left);
            preorder(root.right);
        }
        else
        {
            preorder.append("N").append(",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return buildTree(data.split(","));
    }

    TreeNode buildTree(String[] data)
    {
        if(preorderIndex>=data.length)
            return null;

        String val = data[preorderIndex++];
        TreeNode node;

        if("N".equals(val))
        {
            return null;
        }
        
        else
        {
            node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(data);
            node.right = buildTree(data);
        }
        return node;
    }
}
