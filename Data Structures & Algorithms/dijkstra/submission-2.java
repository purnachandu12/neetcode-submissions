class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        int[] distance=new int[n];
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        queue.add(new pair(src,0));
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int node=current.node;
            for(int i=0;i<edges.size();i++){
                if(edges.get(i).get(0)==current.node){
                    int edge=edges.get(i).get(1);
                    int weight=edges.get(i).get(2);
                    if(distance[edge]>current.weight+weight){
                        distance[edge]=current.weight+weight;
                        queue.add(new pair(edge,distance[edge]));
                    }
                }
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                map.put(i,-1);
            }
            else{
            map.put(i,distance[i]);
            }
        }
        return map;
    }  
}
class pair{
    int node;
    int weight;
    public pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
