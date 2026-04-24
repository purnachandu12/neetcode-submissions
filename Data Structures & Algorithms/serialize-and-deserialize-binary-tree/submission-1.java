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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        String s="";
        s=s+root.val+",";
        while(queue.isEmpty()!=true){
            TreeNode current=queue.remove();
            String left="#,";
            String right="#,";
            if(current.left!=null){
                queue.add(current.left);
                left=current.left.val+",";
            }
            if(current.right!=null){
                queue.add(current.right);
                right=current.right.val+",";
            }
            s=s+left+right;
        }
        System.out.println(s.substring(0,s.length()-1));
        return s.substring(0,s.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] nodes=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(queue.isEmpty()!=true){
            TreeNode current = queue.poll();

        // Left child
        if (i<nodes.length && !nodes[i].equals("#")) {
            TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
            current.left = left;
            queue.add(left);
        }
        i++;

        // Right child
        if (i < nodes.length && !nodes[i].equals("#")) {
            TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
            current.right = right;
            queue.add(right);
        }
        i++;
        }
        return root;
    }
}
