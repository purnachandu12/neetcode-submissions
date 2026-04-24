class Solution {
    public int firstMissingPositive(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
            set.add(nums[i]);
        }
        if(max<=0){
            return 1;
        }
        for(int i=1;i<=max;i++){
            if(set.contains(i)!=true && i>0){
                return i;
            }
        }
        return max+1;
    }
}