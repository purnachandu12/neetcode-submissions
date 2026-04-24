class Solution {
    public String longestPalindrome(String s) {
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(palindrome(s.substring(i,j+1))==true){
                    if(j-i+1>max){
                        max=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        if(max==Integer.MIN_VALUE){
            return "";
        }
        return s.substring(start,end+1);
    }
    public static boolean palindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
