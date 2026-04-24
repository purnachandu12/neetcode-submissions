class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i))!=true){
                map.put(s1.charAt(i),1);
            }
            else{
                int value=map.get(s1.charAt(i));
                value++;
                map.put(s1.charAt(i),value);
            }
        }
        int i=0;
        int j=0;
        int count=map.size();
        int k=s1.length();
        while(j<s2.length()){
            if(map.containsKey(s2.charAt(j))==true){
                int value=map.get(s2.charAt(j));
                value--;
                if(value==0){
                    count--;
                }
                map.put(s2.charAt(j),value);
            }
            if(j-i+1==k){
                if(count==0){
                    return true;
                }
                if(map.containsKey(s2.charAt(i))==true){
                    int value=map.get(s2.charAt(i));
                    if(value==0){
                        count++;
                    }
                    value++;
                    map.put(s2.charAt(i),value);
                }
                i++;               
            }
            j++;
        }
        return false;
}
}
