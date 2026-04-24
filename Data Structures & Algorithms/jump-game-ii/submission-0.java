class Solution {
    public int jump(int[] nums) {
        return solve(nums,0,0);
    }
    public static int solve(int[] nums,int index,int jumps){
        if(index>=nums.length-1){
            return jumps;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            min=Math.min(solve(nums,index+i,jumps+1),min);
        }
        return min;
    }
}
