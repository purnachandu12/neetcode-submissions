class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start=strs[0];
        String end=strs[strs.length-1];
        int i=0;
        int j=0;
        String ans="";
        while(i<start.length() && j<end.length()){
            if(start.charAt(i)==end.charAt(j)){
                ans=ans+start.charAt(i);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}