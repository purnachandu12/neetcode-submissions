class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    ArrayList<Integer> a1=new ArrayList<>();
                    a1.add(nums[i]);
                    a1.add(nums[j]);
                    a1.add(nums[k]);
                    result.add(a1);
                    k--;
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
