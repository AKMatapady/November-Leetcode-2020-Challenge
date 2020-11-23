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
    
    private class sub
    {
        int with;
        int without;
        
        sub(int a, int b)
        {
            with = a;
            without = b;
        }
    }
    
    private sub recur(TreeNode root)
    {
        if(root == null)
            return new sub(0, 0);
        sub left = recur(root.left);
        sub right = recur(root.right);
        
        int with = root.val + left.without + right.without;
        int without = Math.max(left.with, left.without) + Math.max(right.with, right.without);
        
        return new sub(with, without);
    }
    
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        sub ans = recur(root);
        return Math.max(ans.with, ans.without);
    }
}