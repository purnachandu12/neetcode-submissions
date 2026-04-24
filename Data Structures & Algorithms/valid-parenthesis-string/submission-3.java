class Solution {
    public boolean checkValidString(String s) {
       return solve(s,0,0);
    }
    public static boolean solve(String s,int index,int value){
        if(value<0){
            return false;
        }
        if(index==s.length() && value!=0){
            return false;
        }
        if(index==s.length() && value==0){
            return true;
        }
        if(s.charAt(index)=='('){
            return solve(s,index+1,value+1);
        }
        else if(s.charAt(index)==')'){
            return solve(s,index+1,value-1);
        }
        else{
            boolean right=solve(s,index+1,value-1);
            boolean left=solve(s,index+1,value+1);
            boolean leave=solve(s,index+1,value);
            return right||left||leave;
        }
    }
}
