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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        ArrayList<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayList<Integer> roo=new ArrayList<>();
        roo.add(root.val);
        result.add(roo);
        while(queue.isEmpty()!=true){
            int size=queue.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode current=queue.remove();
                if(current.left!=null){
                    queue.add(current.left);
                    temp.add(current.left.val);
                }
                if(current.right!=null){
                    queue.add(current.right);
                    temp.add(current.right.val);
                }
            }
            if(temp.size()!=0){
            result.add(temp);
            }
        }
        return result;
    }
}
