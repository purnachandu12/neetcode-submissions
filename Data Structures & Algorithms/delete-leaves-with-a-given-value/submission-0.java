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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return solve(root,target);
    }
    public static TreeNode solve(TreeNode root,int value){
        if(root==null){
            return null;
        }
        if(isleaves(root)==true && root.val==value){
            return null;
        }
        root.left=solve(root.left,value);
        root.right=solve(root.right,value);
        if(root.left==null && root.right==null && root.val==value){
            return null;
        }
        return root;
    }
    public static boolean isleaves(TreeNode root){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        else{
            return false;
        }
    }
}