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
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        solve(root,max);
        return max[0];
    }
    public static int solve(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,solve(root.left,max));
        int right=Math.max(0,solve(root.right,max));
        int sum=left+right+root.val;
        max[0]=Math.max(max[0],sum);
        return root.val+Math.max(left,right);
    }
}
