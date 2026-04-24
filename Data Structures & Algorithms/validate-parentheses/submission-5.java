class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()==true){
                    return false;
                }
                else if(s.charAt(i)==')' && stack.peek()=='('){
                if(stack.isEmpty()==true){
                    return false;
                }
                stack.pop();
            }
            else if(s.charAt(i)==']' &&  stack.peek()=='['){
                if(stack.isEmpty()==true){
                    return false;
                }
                stack.pop();
            }
            else if(s.charAt(i)=='}' && stack.peek()=='{'){
                if(stack.isEmpty()==true){
                    return false;
                }
                stack.pop();
            }
            else{
                return false;
            }
            }
            i++;
        }
        if(stack.isEmpty()==true){
            return true;
        }
        else{
            return false;
        }
    }
}
