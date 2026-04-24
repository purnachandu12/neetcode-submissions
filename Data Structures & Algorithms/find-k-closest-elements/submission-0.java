class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator comparator=new Comparator<pair>(){
            public int compare(pair p1,pair p2){
                if(p1.diff==p2.diff){
                    return p2.value-p1.value;
                }
                return p2.diff-p1.diff;
            }
        };
        PriorityQueue<pair> queue=new PriorityQueue<>(comparator);
        for(int i=0;i<arr.length;i++){
            queue.add(new pair(arr[i],Math.abs(arr[i]-x)));
            if(queue.size()>k){
                queue.remove();
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(queue.isEmpty()!=true){
            result.add(queue.remove().value);
        }
        Collections.sort(result);
        return result;
    }
}
class pair{
    int value;
    int diff;
    public pair(int value,int diff){
        this.value=value;
        this.diff=diff;
    }
}