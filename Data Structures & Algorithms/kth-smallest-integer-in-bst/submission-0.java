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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        solve(root,result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
        return result.get(k-1);
    }
    public static void solve(TreeNode root,ArrayList<Integer> result){
        if(root==null){
            return;
        }
        solve(root.left,result);
        result.add(root.val);
        solve(root.right,result);
    }
}
