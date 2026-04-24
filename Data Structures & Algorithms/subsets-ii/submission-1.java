class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<Integer> a1=new ArrayList<>();
        solve(nums,a1,res,0);
        return new ArrayList<>(res);
    }
    public static void solve(int[] nums,ArrayList<Integer> temp,Set<List<Integer>> result,int index){
        if(index==nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[index]);
        solve(nums,temp,result,index+1);
        temp.remove(temp.size()-1);
        solve(nums,temp,result,index+1);
    }
}
