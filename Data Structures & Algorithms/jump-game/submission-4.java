class Solution {
public boolean canJump(int[] nums) {
        int max_jump=0;
        for(int i=0;i<nums.length;i++){
            if(max_jump<i){
                break;
            }
            max_jump=Math.max(max_jump,i+nums[i]);
        }
        if(max_jump>=nums.length-1){
            System.out.println(max_jump);
            return true;
        }
        else{
            System.out.println(max_jump);
            return false;
        }
    }
}
