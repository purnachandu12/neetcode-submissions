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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current=root;
        root=solve(current,val);
        return root;
    }
    public  TreeNode solve(TreeNode root,int val){
        if(root==null){
            TreeNode node=new TreeNode(val);
            return node;
        }
        if(val<=root.val){
            root.left=solve(root.left,val);
        }
        else{
            root.right=solve(root.right,val);
        }
        return root;
    }
}