class Solution {
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        for(int i=0;i<arr.length;i++){
            if(i==0 || i==arr.length-1){
                arr[i]=1;
            }
            else{
                arr[i]=nums[i-1];
            }
        }
        return solve(arr,1,arr.length-2);
    }
    public static int solve(int[] arr,int left,int right){
        if(left>right){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            int temp=(arr[left-1]*arr[i]*arr[right+1])+solve(arr,left,i-1)+solve(arr,i+1,right);
            max=Math.max(max,temp);
        }
        return max;
    }
}
