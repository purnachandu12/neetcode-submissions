class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        int i=0;
        while(i<tokens.length){
            if(tokens[i].equals("+") ||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/") ){
                int value1=Integer.parseInt(stack.pop());
                int value2=Integer.parseInt(stack.pop());
                if(tokens[i].equals("+")){
                    int value=value2+value1;
                    String result=Integer.toString(value);
                    stack.push(result);
                }
                else if(tokens[i].equals("-")){
                    int value=value2-value1;
                    String result=Integer.toString(value);
                    stack.push(result);
                }
                else if(tokens[i].equals("*")){
                    int value=value2*value1;
                    String result=Integer.toString(value);
                    stack.push(result);
                }
                else if(tokens[i].equals("/")){
                    int value=value2/value1;
                    String result=Integer.toString(value);
                    stack.push(result);
                }
            }
            else{
                stack.add(tokens[i]);
            }
            i++;
        }
        String ans=stack.pop();
        int answer=Integer.parseInt(ans);
        return answer;
    }
}
