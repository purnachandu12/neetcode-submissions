class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1];
        int max=-1;
        while(left<=right){
            int mid=(left+right)/2;
            int ans=check(nums,mid);
            if(ans==mid){
                max=Math.max(max,ans);
                left=mid+1;
            }
            else if(ans>mid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return max;
    }
    public int check(int[] nums,int value){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=value){
                count++;
            }
        }
        return count;
    }
}