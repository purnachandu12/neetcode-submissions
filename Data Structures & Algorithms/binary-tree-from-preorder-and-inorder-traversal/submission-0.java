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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public  TreeNode solve(int[] preorder, int start_pre, int end_pre, int[] inorder, int start_in, int end_in, HashMap<Integer,Integer> map) {
        if(start_pre > end_pre || start_in > end_in) {
            return null;
        }

        int rootVal = preorder[start_pre];
        TreeNode root=new TreeNode(rootVal);
        int index = map.get(rootVal);
        int nums_left = index - start_in;

        root.left = solve(preorder, start_pre + 1, start_pre + nums_left, inorder, start_in, index - 1, map);
        root.right = solve(preorder, start_pre + nums_left + 1, end_pre, inorder, index + 1, end_in, map);

        return root;
    }
}
