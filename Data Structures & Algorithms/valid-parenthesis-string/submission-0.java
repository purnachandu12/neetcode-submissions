class Solution {
    public boolean checkValidString(String s) {
        return check(s,0,0);
    }
    public static boolean check(String s,int index,int value){
        if(index==s.length() && value==0){
            return true;
        }
        if(index==s.length() && value!=0){
            return false;
        }
        if(value==-1){
            return false;
        }
        if(s.charAt(index)=='*'){
            boolean right=check(s,index+1,value+1);
            boolean left=check(s,index+1,value-1);
            boolean leave=check(s,index+1,value);
            return right||left||leave;
        }
        else if(s.charAt(index)=='('){
            return check(s,index+1,value+1);
        }
        else{
            return check(s,index+1,value-1);
        }
    }
}
