class Solution {
    public int jump(int[] nums) {
        int left=0;
        int jump=0;
        int right=0;
        while(right<nums.length-1){
            int far=0;
            for(int i=left;i<=right;i++){
                far=Math.max(nums[i]+i,far);
            }
            left=right+1;
            right=far;
            jump++;
        }
        return jump;
    }
}
