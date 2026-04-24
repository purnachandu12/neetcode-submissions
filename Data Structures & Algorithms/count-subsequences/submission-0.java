class Solution {
    public int numDistinct(String s, String t) {
        return solve(s,t,"",0);
    }
    public static int solve(String s,String t,String ans,int index){
        if(ans.equals(t)){
            return 1;
        }
        if(index>=s.length()){
            return 0;
        }
        int take=solve(s,t,ans+s.charAt(index),index+1);
        int skip=solve(s,t,ans,index+1);
        return take+skip;
    }
}
