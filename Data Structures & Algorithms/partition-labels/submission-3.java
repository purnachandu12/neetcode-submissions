class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int i=0;
        int j=0;
        List<Integer> result=new ArrayList<>();
        while(i<s.length()){
            int last=map.get(s.charAt(i));
            while(j<=last){
                last=Math.max(last,map.get(s.charAt(j)));
                j++;
            }
            result.add(j-i);
            i=j;
        }
        return result;
    }
}
