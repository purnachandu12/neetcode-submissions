class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        solution(nums,temp,0,result);
        return result;
    }
    public static void solution(int[] nums,ArrayList<Integer> temp,int index,ArrayList<List<Integer>> result){
        if(index>=nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        solution(nums,temp,index+1,result);
        temp.remove(temp.size()-1);
        solution(nums,temp,index+1,result);
    }
}
