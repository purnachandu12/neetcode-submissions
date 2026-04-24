class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(0,-1));
        int[] visited=new int[n];
        visited[0]=1;
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int node=current.node;
            int parent=current.parent;
            for(int i=0;i<adj.get(node).size();i++){
                int node2=adj.get(node).get(i);
                if(visited[node2]==0){
                    visited[node2]=1;
                    queue.add(new pair(node2,node));
                }
                else if(visited[node2]==1 && node2!=parent){
                    return false;
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]!=1){
                return false;
            }
        }
        return true;
    }
}
class pair{
    int node;
    int parent;
    pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}