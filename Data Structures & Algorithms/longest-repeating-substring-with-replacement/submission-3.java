class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int count=0;
        int length=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int max_frequency=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))!=true){
                map.put(s.charAt(j),1);
                max_frequency=Math.max(max_frequency,1);
            }
            else{
                int value=map.get(s.charAt(j));
                value++;
                max_frequency=Math.max(max_frequency,value);
                map.put(s.charAt(j),value);
            }
            if((j-i+1)-max_frequency<=k){
                length=Math.max(length,j-i+1);
            }
            else{
                int value=map.get(s.charAt(i));
                value--;
                map.put(s.charAt(i),value);
                i++;
            }
            j++;
        }
        return length;
    }
}
