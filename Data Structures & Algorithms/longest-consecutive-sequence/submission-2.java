class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int length=1;
        int result=1;
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]-1){
                length++;
                result=Math.max(result,length);
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                length=1;
            }
        }
        return result;
    }
}
