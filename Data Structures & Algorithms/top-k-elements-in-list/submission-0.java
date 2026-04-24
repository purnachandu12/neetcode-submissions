class Solution{
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])!=true){
                map.put(nums[i],1);
            }
            else{
                int value=map.get(nums[i]);
                value=value+1;
                map.put(nums[i],value);
            }
        }
         Comparator<pair> comparator=new Comparator<pair>() {
          @Override
          public int compare(pair first,pair secound){
            return first.value2-secound.value2;
          }  
        };
        ArrayList<Integer> a1=new ArrayList<>();
        PriorityQueue<pair> minHeap=new PriorityQueue<>(comparator);
        for(int i=0;i<nums.length;i++){
            if(a1.contains(nums[i])!=true){
                minHeap.add(new pair(nums[i],map.get(nums[i])));
                if(minHeap.size()>k){
                    minHeap.poll();
                }
            }
            a1.add(nums[i]);
        }
        int[] result=new int[k];
        int i=0;
        while(minHeap.size()!=0){
            pair current=minHeap.poll();
            result[i]=current.value1;
            i++;
        }
        for(int j=0;j<result.length;j++){
            System.out.println("c"+result[j]);
        }
        return result;
    }
}
class pair{
    int value1;
    int value2;
    public pair(int value1,int value2){
        this.value1=value1;
        this.value2=value2;
    }
}