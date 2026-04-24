class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] postfix=new int[nums.length];
        prefix[0]=nums[0];
        postfix[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            postfix[i]=postfix[i+1]*nums[i];
        }
        int[] result=new int[nums.length];
        result[0]=postfix[1];
        result[nums.length-1]=prefix[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            result[i]=prefix[i-1]*postfix[i+1];
        }
       
        return result;
    }
}  
