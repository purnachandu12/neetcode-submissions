class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] temp1=new char[s.length()];
        char[] temp2=new char[t.length()];
        for(int i=0;i<s.length();i++){
            temp1[i]=s.charAt(i);
            temp2[i]=t.charAt(i);
        }
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        if(Arrays.equals(temp1,temp2)){
            return true;
        }
        else{
            return false;
        }
    }
}
