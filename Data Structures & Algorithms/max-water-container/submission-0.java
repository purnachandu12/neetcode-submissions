class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int result=0;
        int temp=0;
        int area=0;
        while(i<j){
           if(heights[i]<heights[j]){
            temp=heights[i];
            area=temp*(j-i);
            result=Math.max(result,area);
            i++;
           }
           else{
            temp=heights[j];
            area=temp*(j-i);
            result=Math.max(result,area);
            j--;
           }
        }
        return result;
    }
}
