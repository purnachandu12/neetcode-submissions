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
    public boolean isBalanced(TreeNode root) {
    if(root==null){
        return true;
    }
      if(Math.abs(helper(root.right)-helper(root.left))>1){
        return false;
      }
      boolean right=isBalanced(root.right);
      boolean left=isBalanced(root.left);
      return right&&left;
    }
    public static int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        return 1+Math.max(left,right);
    }
}
