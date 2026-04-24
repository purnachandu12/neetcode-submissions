class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int size=1;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))!=true){
                map.put(s.charAt(j),1);
            }
            else{
                int value=map.get(s.charAt(j));
                value++;
                map.put(s.charAt(j),value);
            }
            if(map.size()==j-i+1){
                size=Math.max(size,j-i+1);
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    int value=map.get(s.charAt(i));
                    value--;
                    if(value==0){
                        map.remove(s.charAt(i));
                    }
                    else{
                        map.put(s.charAt(i),value);
                    }
                    i++;
                }
            }
            j++;
        }
        return size;
    }
}
