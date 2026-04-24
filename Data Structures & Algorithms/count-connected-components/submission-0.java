class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]!=true){
                count++;
                bfs(adj,i,visited);
            }
        }
        return count;
    }
    public static void bfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        while(queue.isEmpty()!=true){
            int current=queue.remove();
            for(int i=0;i<adj.get(current).size();i++){
                if(visited[adj.get(current).get(i)]!=true){
                    queue.add(adj.get(current).get(i));
                    visited[adj.get(current).get(i)]=true;
                }
            }
        }
    }
}
