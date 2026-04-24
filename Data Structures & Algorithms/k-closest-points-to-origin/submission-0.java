class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<pair> comparator=new Comparator<pair>() {
            @Override
            public int compare(pair p1,pair p2){
                return p2.distance-p1.distance;
            }
        };
        PriorityQueue<pair> maxheap=new PriorityQueue<>(comparator);
        for(int i=0;i<points.length;i++){
            int distance=((points[i][0])*(points[i][0]))+((points[i][1])*(points[i][1]));
            maxheap.add(new pair(points[i][0],points[i][1],distance));
            while(maxheap.size()>k){
                maxheap.remove();
            }
        }
        int[][] result=new int[maxheap.size()][2];
        int it=0;
        while(maxheap.isEmpty()!=true){
            pair current=maxheap.remove();
            result[it][0]=current.x;
            result[it][1]=current.y;
            it++;
        }
        return result;
    }
}
class pair{
    int x;
    int y;
    int distance;
    pair(int x,int y,int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}
