class Solution {
    public int appendCharacters(String s, String t) {
        int index=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(index==t.length()){
                break;
            }
            if(s.charAt(i)==t.charAt(index)){
                index++;
                count++;
            }
        }
        System.out.println(count);
        return t.length()-count;
    }
}