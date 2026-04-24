class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] result=nsl(heights);
        int[] result2=nsr(heights);
        int[] width=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            width[i]=(result2[i]-result[i]-1)*heights[i];
        }
        int max=0;
        for(int i=0;i<width.length;i++){
            max=Math.max(max,width[i]);
        }
        return max;
    }
    public int[] nsl(int[] heights){
        Stack<Integer> stack=new Stack<Integer>();
        int[] result=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()==true){
                stack.add(i);
                result[i]=-1;
            }
            else if(heights[stack.peek()]<heights[i]){
                result[i]=stack.peek();
                stack.add(i);
            }
            else if(heights[stack.peek()]>=heights[i]){
                while(stack.isEmpty()!=true && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()==true){
                    result[i]=-1;
                    stack.add(i);
                }
                else{
                    result[i]=stack.peek();
                    stack.add(i);
                }
            }
        }
        return result;
    }
    public int[] nsr(int[] heights){
        Stack<Integer> stack=new Stack<Integer>();
        int[] result=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()==true){
                stack.add(i);
                result[i]=heights.length;
            }
            else if(heights[stack.peek()]<heights[i]){
                result[i]=stack.peek();
                stack.add(i);
            }
            else if(heights[stack.peek()]>=heights[i]){
                while(stack.isEmpty()!=true && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()==true){
                    result[i]=heights.length;
                    stack.add(i);
                }
                else{
                    result[i]=stack.peek();
                    stack.add(i);
                }
            }
        }
        return result;
    }
}