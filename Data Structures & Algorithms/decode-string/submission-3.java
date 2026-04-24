class Solution {
    public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                String temp="";
                while(stack.isEmpty()!=true && stack.peek().equals("[")!=true){
                   temp=stack.pop()+temp;
                }
                System.out.println(temp);
                stack.pop();
                String s2="";
                while(stack.isEmpty()!=true && Character.isDigit(stack.peek().charAt(0))==true){
                    s2=stack.pop()+s2;
                }
                int value=Integer.parseInt(s2);
                System.out.println(value);
                String ans1="";
                for(int j=0;j<value;j++){
                   ans1=temp+ans1;
                }
                stack.push(ans1);
            }
            else{
                stack.push(Character.toString(s.charAt(i)));
            }
        }
        while(stack.isEmpty()!=true){
            ans=stack.pop()+ans;
        }
        return ans;
    }
}