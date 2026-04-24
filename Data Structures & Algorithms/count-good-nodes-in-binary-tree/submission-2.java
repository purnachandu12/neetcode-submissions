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
    public int goodNodes(TreeNode root) {
       int[] arr=new int[1]; 
       int[] arr1=new int[1];
       solve(root.right,root.val,arr);
       solve(root.left,root.val,arr1);
       return arr[0]+arr1[0]+1;
    }
    public static void solve(TreeNode root,int max,int[] arr){
        if(root==null){
            return;
        }
        if(root.val>=max){
            arr[0]++;
            solve(root.left,root.val,arr);
            solve(root.right,root.val,arr);
        }
        else{
            solve(root.left,max,arr);
            solve(root.right,max,arr);
        }
    }
}
