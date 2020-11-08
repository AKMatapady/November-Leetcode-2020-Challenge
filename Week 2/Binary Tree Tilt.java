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
    
    private int recur(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null)
        {
            left = recur(root.left);
        }
        if(root.right != null)
        {
            right = recur(root.right);
        }
        ans += Math.abs(left-right);
        return root.val+left+right;
    }
    
    int ans;
    public int findTilt(TreeNode root) {
        ans = 0;
        if(root == null)
            return ans;
        recur(root);
        return ans;
    }
}