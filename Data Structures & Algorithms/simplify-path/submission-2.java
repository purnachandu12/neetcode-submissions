class Solution {
    public String simplifyPath(String s) {
       String[] arr=s.split("/");
       for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
       }
       Stack<String> stack=new Stack<>();
       for(int i=0;i<arr.length;i++){
        if(arr[i].equals(".") || arr[i].equals("")){
            continue;
        }
        else if(arr[i].equals("..")){
            if(stack.isEmpty()!=true){
                stack.pop();
            }
        }
        else{
            stack.push(arr[i]);
        }
       }
       String temp="";
       while(stack.isEmpty()!=true){
        temp="/"+stack.pop()+temp;
       }
       if(temp.length()==0){
        return "/";
       }
       return temp;
    }
    /*public static String reverse(String temp){
        String ans="";
        for(int i=temp.length()-1;i>=0;i--){
            ans=ans+temp.charAt(i);
        }
        return ans;
    }*/

}