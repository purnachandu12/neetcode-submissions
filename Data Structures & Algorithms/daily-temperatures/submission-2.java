class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<pair> stack=new Stack<>();
        int[] result=new int[temperatures.length];
        int k=0;
        for(int j=temperatures.length-1;j>=0;j--){
            if(stack.isEmpty()==true){
                result[k]=0;
                k++;
            }
            else if(temperatures[j]<stack.peek().value){
                pair value=stack.peek();
                result[k]=value.index-j;
                k++;
            }
            else if(temperatures[j]>=stack.peek().value){
                while(stack.isEmpty()!=true && temperatures[j]>=stack.peek().value){
                    stack.pop();
                }
                if(stack.isEmpty()==true){
                    result[k]=0;
                    k++;
                }
                else{
                    pair current=stack.peek();
                    result[k]=current.index-j;
                    k++;
                }
            }
            stack.push(new pair(temperatures[j],j));
        }
        for(int i=0;i<result.length/2;i++){
            int temp=result[i];
            result[i]=result[result.length-i-1];
            result[result.length-i-1]=temp;
        }
        return result;
    }
}
class pair{
    int value;
    int index;
    pair(int value,int index){
        this.value=value;
        this.index=index;
    }
}
