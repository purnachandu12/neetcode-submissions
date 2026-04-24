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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> a1=new ArrayList<>();
        if(root==null){
            return a1;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(queue.isEmpty()!=true){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current=queue.remove();
                if(map.containsKey(level)!=true){
                    map.put(level,current.val);
                }
            if(current.right!=null){
                queue.add(current.right);
            }
            if(current.left!=null){
                queue.add(current.left);
            }
            }
            level++;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    a1.add(entry.getValue());
}
        return a1;
    }
}
