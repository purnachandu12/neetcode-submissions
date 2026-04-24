class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] result1=nsl(heights);
        int[] result2=nsr(heights);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int value=result2[i]-result1[i]-1;
            max=Math.max(max,value*heights[i]);
        }
        return max;
    }
    public static int[] nsl(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(stack.isEmpty()!=true && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()==true){
                result[i]=-1;
            }
            else{
                result[i]=stack.peek();
            }
            stack.add(i);
        }
        return result;
    }
    public static int[] nsr(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(stack.isEmpty()!=true && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()==true){
                result[i]=heights.length;
            }
            else{
                result[i]=stack.peek();
            }
            stack.add(i);
        }
        return result;
    }
}
