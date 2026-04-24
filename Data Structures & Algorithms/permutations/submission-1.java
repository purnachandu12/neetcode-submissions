class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        solve(nums,result,0);
        return result;
    }
    public static void solve(int[] nums,ArrayList<List<Integer>> result,int index){
        if(index==nums.length-1){
             ArrayList<Integer> temp=new ArrayList<>();
            for (int num : nums) temp.add(num);
            result.add(temp);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            solve(nums,result,index+1);
            swap(nums,index,i);
        }
    }
    public static void swap(int[] nums,int index,int i){
        int temp=nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
        return;
    }
}
