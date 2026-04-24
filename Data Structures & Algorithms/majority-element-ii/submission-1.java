class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        Arrays.sort(nums);
        int left=0;
        int right=0;
        int count=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(right<nums.length){
            if(nums[right]==nums[left]){
                count++;
                right++;
            }
            else{
                System.out.println("executed");
                if(count>n){
                    list.add(nums[left]);
                }
                left=right;
                count=0;
            }
        }
        if(count>n){
            list.add(nums[nums.length-1]);
        }
        return list;
    }
}