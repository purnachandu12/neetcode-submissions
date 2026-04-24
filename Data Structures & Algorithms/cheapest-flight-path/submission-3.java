class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Comparator<pair> comparator=new Comparator<>(){
            public int compare(pair p1,pair p2){
                return p1.stops-p2.stops;
            }
        };
        PriorityQueue<pair> queue=new PriorityQueue<>(comparator);
        int[] distance=new int[n+1];
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        queue.add(new pair(src,0,0));
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            for(int i=0;i<flights.length;i++){
                if(flights[i][0]==current.node){
                    if(distance[flights[i][1]]>current.dist+flights[i][2] && current.stops<k+1){
                        distance[flights[i][1]]=current.dist+flights[i][2];
                        queue.add(new pair(flights[i][1],distance[flights[i][1]],current.stops+1));
                    }
                }
            }
        }
        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];
    }
}
class pair{
    int node;
    int dist;
    int stops;
    public pair(int node,int dist,int stops){
        this.node=node;
        this.dist=dist;
        this.stops=stops;
    }
}
