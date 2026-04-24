class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            left=Math.max(weights[i],left);
            sum=sum+weights[i];
        }
        int right=sum;
        int result=0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int requiredDays = solve(weights, mid);
            if (requiredDays <= days) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static int solve(int[] weights,int max){
        int sum=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>max){
                sum=0;
                days++;
            }
            sum=sum+weights[i];
        }
        return days;
    }
}