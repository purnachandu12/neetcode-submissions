class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)==true){
                count=count+map.get(sum-k);
            }
            if(map.containsKey(sum)!=true){
                map.put(sum,1);
            }
            else{
                int count1=map.get(sum);
                count1++;
                map.put(sum,count1);
            }
        }
        return count;
    }
}