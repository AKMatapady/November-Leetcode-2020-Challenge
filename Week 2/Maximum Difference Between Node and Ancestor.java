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
    
    private void recur(TreeNode curr, int max, int min)
    {
        if(curr == null)
        {
            ans = Math.max(ans, max-min);
            return;
        }
        recur(curr.left, Math.max(max, curr.val), Math.min(min, curr.val));
        recur(curr.right, Math.max(max, curr.val), Math.min(min, curr.val));
    }
    
    int ans;
    
    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        if(root == null)
            return ans;
        recur(root, root.val, root.val);
        return ans;
    }
}