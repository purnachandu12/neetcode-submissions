public class Solution{
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])!=true){
                map.put(nums[i],1);
            }
            else{
                int value=map.get(nums[i]);
                value++;
                map.put(nums[i],value);
            }
        }
        Comparator<pair> comparator=new Comparator<pair>() {
            @Override
            public int compare(pair a1,pair a2){
                return a1.freq-a2.freq;
            }
        };
        PriorityQueue<pair> min=new PriorityQueue<>(comparator);
        ArrayList<Integer> a1=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(a1.contains(nums[i])!=true){
                min.add(new pair(nums[i],map.get(nums[i])));
                if(min.size()>k){
                    min.poll();
                }
            }
            a1.add(nums[i]);
        }
        int[] result=new int[k];
        int k2=0;
        while(min.size()!=0){
            pair current=min.remove();
            result[k2]=current.value;
            k2++;
        }
        return result;
    }
}
class pair{
    int value;
    int freq;
    public pair(int value,int freq){
        this.value=value;
        this.freq=freq;
    }
}
