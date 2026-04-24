class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<node> queue=new LinkedList<>();
        queue.add(new node(k,0));
        int[] distance=new int[n+1];
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[k]=0;
        while(queue.isEmpty()!=true){
            node current=queue.remove();
            for(int i=0;i<times.length;i++){
                if(times[i][0]==current.node){
                    if(distance[times[i][1]]>current.dist+times[i][2]){
                        distance[times[i][1]]=current.dist+times[i][2];
                        queue.add(new node(times[i][1],distance[times[i][1]]));
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<distance.length;i++){
            max=Math.max(max,distance[i]);
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
        }
        return max;
    }
}
class node{
    int node;
    int dist;
    public node(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
