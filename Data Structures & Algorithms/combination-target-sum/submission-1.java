class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<List<Integer>> result=new ArrayList<>();
        int sum=0;
        helper(nums,0,temp,result,sum,target);
        return result;
    }
    public static void helper(int[] nums,int index,ArrayList<Integer> temp, ArrayList<List<Integer>> result,int sum,int target){
        if(sum==target){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(index>=nums.length){
            return;
        }
        if(sum>target){
            return;
        }
            temp.add(nums[index]);
            helper(nums,index,temp,result,sum+nums[index],target);
            temp.remove(temp.size()-1);
            helper(nums,index+1,temp,result,sum,target);
    }
}
