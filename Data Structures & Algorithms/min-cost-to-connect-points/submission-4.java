class Solution {
    public int minCostConnectPoints(int[][] points) {
        Comparator comparator=new Comparator<pair>(){
            public int compare(pair p1,pair p2){
                return p1.dist-p2.dist;
            }
        };
        PriorityQueue<pair> queue=new PriorityQueue<>(comparator);
        queue.add(new pair(0,0));
        boolean[] visited=new boolean[points.length];
        visited[0]=true;
        int sum=0;
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            if(visited[current.value]!=true){
                sum=sum+current.dist;
                visited[current.value]=true;
            }
            for(int i=0;i<points.length;i++){
                if(visited[i]!=true){
                    int distance=distance(points[current.value][0],points[current.value][1],points[i][0],points[i][1]);
                    queue.add(new pair(i,distance));
                }
            }
        }
        return sum;
    }
    public int distance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
class pair{
    int value;
    int dist;
    public pair(int value,int dist){
        this.value=value;
        this.dist=dist;
    }
}

