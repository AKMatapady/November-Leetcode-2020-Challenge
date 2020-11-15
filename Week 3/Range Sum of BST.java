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
    
    int min, max, sum;
    
    private void traverse(TreeNode root)
    {
        if(root.val >= min && root.val <= max)
            sum += root.val;
        if(root.left != null)
            traverse(root.left);
        if(root.right != null)
            traverse(root.right);
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        min = low;
        max = high;
        sum = 0;
        if(root == null)
            return sum;
        traverse(root);
        return sum;
    }
}