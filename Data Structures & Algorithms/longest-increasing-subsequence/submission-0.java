class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp=new ArrayList<>();
        return solve(nums,0,temp);
    }
    public static int solve(int[] nums,int index,ArrayList<Integer> temp){
        if(index>=nums.length){
            if(strictly(temp)==true){
                return temp.size();
            }
            else{
                return 0;
            }
        }
        temp.add(nums[index]);
        int take=solve(nums,index+1,temp);
        temp.remove(temp.size()-1);
        int skip=solve(nums,index+1,temp);
        return Math.max(take,skip);
    }
    public static boolean strictly(ArrayList<Integer> temp){
        if(temp.size()==0){
            return false;
        }
        for(int i=1;i<temp.size();i++){
            if(temp.get(i)<=temp.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
