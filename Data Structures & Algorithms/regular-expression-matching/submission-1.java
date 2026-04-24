class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s,p,0,0);
    }
    public static boolean solve(String s,String p,int index1,int index2){
        if(index1==s.length() && index2==p.length()){
            return true;
        }
        if(index2==p.length()){
            return false;
        }
        boolean match=false;
        if(index1<s.length()){
            if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='.'){
                match=true;
            }
        }
        if((index2+1)<p.length() && p.charAt(index2+1)=='*'){
            boolean skip=solve(s,p,index1,index2+2);
            boolean take=false;
            if(match){
                take=solve(s,p,index1+1,index2);
            }
            return skip||take;
        }
        else{
            if(match==true){
                return solve(s,p,index1+1,index2+1);
            }
            else{
                return false;
            }
        }
    }
}
