class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int index=0;
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return solve(s1,s2,s3,"",0,0,0);
    }
    public static boolean solve(String s1,String s2,String s3,String ans,int index1,int index2,int index3){
        if(ans.equals(s3)==true){
            return true;
        }
        boolean first=false;
        boolean secound=false;
        if(index1<s1.length() && s1.charAt(index1)==s3.charAt(index3)){
            first=solve(s1,s2,s3,ans+s1.charAt(index1),index1+1,index2,index3+1);
        }
        if(index2<s2.length() && s2.charAt(index2)==s3.charAt(index3)){
            secound=solve(s1,s2,s3,ans+s2.charAt(index2),index1,index2+1,index3+1);
        }
        return first||secound;
    }
}
